package AgenceVoyage.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lowagie.text.DocumentException;

import AgenceVoyage.Model.Billet;
import AgenceVoyage.Model.Facture;
import AgenceVoyage.Model.Hotel;
import AgenceVoyage.Model.Offre;
import AgenceVoyage.Model.Omra;
import AgenceVoyage.Model.Reservation;
import AgenceVoyage.Model.Utilisateurs;
import AgenceVoyage.Model.VoyageOrganise;
import AgenceVoyage.Service.FactureServiceImp;
import AgenceVoyage.Service.ReservationService;
import AgenceVoyage.web.dto.ReservationRegistrationDto;
import AgenceVoyage.repository.OffreRepository;
import AgenceVoyage.repository.ReservationRepository;
import AgenceVoyage.repository.UserRepository;


	@Controller
	
public class ReservationRegistrationController {
		
		@Autowired
		private UserRepository user;
		@Autowired
		private OffreRepository offre;
		@Autowired
		private ReservationRepository reservation;
		
		private ReservationService reservationService;
		public static Long num,numOmra,numHotel,numVoyage;

		public ReservationRegistrationController(ReservationService reservationService) {
			super();
			this.reservationService = reservationService;
		}
	
	
	public String recupererEmailCourant() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		   String currentUserName = authentication.getName();
		   return currentUserName;}
		return null;
		}

	
	@GetMapping("/services")
	public String Chercher(Model model,String email,
			@RequestParam(name="depart",defaultValue="") String Villedépart,
			@RequestParam(name="ListeVille",defaultValue="") String VilleArrivee,
			@RequestParam(name="compagnie",defaultValue="") String compagnie)
			 {
		Utilisateurs utilisateurs=user.findByEmail(recupererEmailCourant());
		model.addAttribute("Utilisateurs", utilisateurs);
		//Recherche billet par ville ou compagnie
		List billets=offre.findByVille(Villedépart,VilleArrivee,compagnie);
		model.addAttribute("Billets", billets);
		
		//recuperer les villes des voyages organises disponnible
		List villes = offre.findVieDispo();
		model.addAttribute("Villes", villes);

		//recuperer les Compagnies disponnibles 
		List compagnies = offre.findCompagnieDispo();
		//System.out.println(compagnies);
		model.addAttribute("Compagnies", compagnies);	

		//Recherche omra
			List<Omra> Omras=offre.findOmra();
			model.addAttribute("Omras", Omras);
			 List<VoyageOrganise> Voyages=offre.findAllVoyagesO();
			 model.addAttribute("VoyagesOrganise", Voyages);


			//Recherche Hôtel
			List<Hotel> Hotels=offre.findHotel();
			model.addAttribute("Hotels", Hotels);
		
	return "services";
	}
	
	@GetMapping("/Offre")
	public String trouver(Model model,Long numOffre) {		
		offre.findByNumOffre(numOffre);
		num=offre.findByNumOffre(numOffre).getNumOffre();
		//Retourne l'objet pour le formulaire d'affichage
		Offre offreChoisi=offre.findById(num).get();
		model.addAttribute("offreChoisi",offreChoisi);
		//Recherche dans Billet les villes de départ et destination
		Date dateDepart=offre.findByDateDepart(num);
		Date dateArrivee=offre.findByDateArrivee(num);
		model.addAttribute("dateDepart",dateDepart);
		model.addAttribute("dateArrivee",dateArrivee);
		//La prochaine fois Je dois généraliser la requête pour trouver tt
		
		return "services";
			
		}
		
		@GetMapping("Offre/Omra")
		public String trouverOmra(Model model,Long numOffre) {		
			offre.findByNumOffre(numOffre);
			numOmra=offre.findByNumOffre(numOffre).getNumOffre();	
			return "services";	
		}
	
	//C'est cette reservation qu'on a utilisé en services.html
	@ModelAttribute("reservation") 
	public ReservationRegistrationDto ReservationRegistrationDto() {
		return new ReservationRegistrationDto();
	}
	//C'est cette reservation qu'on a utilisé en services.html
	@ModelAttribute("omra")
	public ReservationRegistrationDto ReservationRegistrationDto1() {
		return new ReservationRegistrationDto();
	}
	//Cette méthode handle http post request
	@PostMapping("/services")
	public  String registerReservation(@ModelAttribute("reservation") ReservationRegistrationDto reservationRegistrationDto) {
		reservationService.save(reservationRegistrationDto);
		return "home";
	}
	//Cette méthode handle http post request
		@PostMapping("/services/omra")
		public  String registerReservationOMra(
					@ModelAttribute("omra") ReservationRegistrationDto reservationRegistrationDto2) {
			
			reservationService.reserverOmra(reservationRegistrationDto2);
			return "home";
		}
		

	
	
	//Generer facture pdf
		@GetMapping("/services/export")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException{
			//set Http headers for file download
			response.setContentType("application/pdf");
			
			 Date currentDateTime = new Date();
	        
			 String headerKey = "Content-Disposition";
		     String headerValue = "attachment; filename=reservation_" + currentDateTime + ".pdf";
		     response.setHeader(headerKey, headerValue);
			
		     //get data from database
		     Utilisateurs utilisateurs=user.findByEmail(recupererEmailCourant());
		     Long numR;
		     
		     if(num!=null) {
		     numR=num;
		     }else {
		     if(numHotel!=null) {
		     numR=numHotel;
		     }else {
		     if(numVoyage!=null)
		     numR=numVoyage;
		     else
		     numR=numOmra;
		    
		     }
		     }
		    
		     Reservation ListReservations = reservation.findR(utilisateurs.getUid(), numR);
		     Offre ListOffres=offre.findByNumOffre(numR);
		     //creat PDF document
		     Facture f=new Facture(ListReservations,ListOffres,utilisateurs);
		     FactureServiceImp exporter =new FactureServiceImp(f);
		     exporter.export(response);
			
		
		}
		/*Détail Hotêl*/
		@GetMapping("/détailHotel")
		public String Hotel(Model model,Long numOffre) {
		Offre offreChoisi=offre.findById(numOffre).get();
		model.addAttribute("offreChoisi",offreChoisi);
		offre.findByNumOffre(numOffre);
		numHotel=offre.findByNumOffre(numOffre).getNumOffre();
		return "détailHotel";
		}
		/*Détail Voyage*/
		@GetMapping("/détailVoyage")
		public String Voyage(Model model,Long numOffre) {
		Offre offreChoisi=offre.findById(numOffre).get();
		model.addAttribute("offreChoisi",offreChoisi);
		offre.findByNumOffre(numOffre);
		numVoyage=offre.findByNumOffre(numOffre).getNumOffre();
		return "détailVoyage";
		}
		
		//pour hotel
		//C'est cette reservation qu'on a utilisé en detailHotel.html
		@ModelAttribute("hotel")
		public ReservationRegistrationDto ReservationRegistrationDto2() {
		return new ReservationRegistrationDto();
		}

		//Cette méthode handle http post request
		@PostMapping("/détailHotel")
		public  String registerReservationHotel(
		@ModelAttribute("hotel") ReservationRegistrationDto reservationRegistrationDto3) {

		reservationService.reserverhotel(reservationRegistrationDto3);
		return "home";
		}


		//pour voyage
		//C'est cette reservation qu'on a utilisé en detailVoyage.html
		@ModelAttribute("voyage")
		public ReservationRegistrationDto ReservationRegistrationDto4() {
		return new ReservationRegistrationDto();
		}

		//Cette méthode handle http post request
		@PostMapping("/détailVoyage")
		public  String registerReservationVoyage(
		@ModelAttribute("voyage") ReservationRegistrationDto reservationRegistrationDto4) {

		reservationService.reserverVoyage(reservationRegistrationDto4);
		return "home";
		}
	
 
	
	
} 
