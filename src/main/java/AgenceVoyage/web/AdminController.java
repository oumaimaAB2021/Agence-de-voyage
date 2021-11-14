package AgenceVoyage.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import AgenceVoyage.Model.Billet;
import AgenceVoyage.Model.Hotel;
import AgenceVoyage.Model.Omra;
import AgenceVoyage.Model.Utilisateurs;
import AgenceVoyage.Model.VoyageOrganise;
import AgenceVoyage.Service.AdminServiceImp;
import AgenceVoyage.Service.UserService;
import AgenceVoyage.repository.OffreRepository;

@Controller
public class AdminController {
	@Autowired
	private OffreRepository offreRepository;
	@Autowired
	private AdminServiceImp adminService;
	@Autowired
	private UserService userService;
	//****************Home Admin*********************
	@GetMapping("/admin")
	public String home() {
		return "HomeAdmin";
	}

	//***********************Voyages organisés*******************************
	@GetMapping("/listvoyage")
	public String showVoyage(Model model)
	{
		List<VoyageOrganise> voyages = adminService.getAllVoyages();
		model.addAttribute("voyages", voyages);
		return "listvoyage";
	}
	@GetMapping("/add")
    public String Addvoyage()
    {
    	return "/addvoyage.html";
    }
	
    @PostMapping("/addV")
    public String savevoyage(@RequestParam("file") MultipartFile file,
    		@RequestParam("titre") String titre,
    		@RequestParam("prix") double prix,
    		@RequestParam("desc") String desc,
    		@RequestParam("Vdepart") String Vdepart,
    		@RequestParam("destination") String destination, 
    		@RequestParam("dateA") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateA,
    		@RequestParam("dateD") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateD
    		)
    		
    {
    	
    	adminService.saveOffreToDB(file, titre, desc, prix, destination,dateD,dateA,Vdepart);
    	return "redirect:/listvoyage";
    }
    
    @GetMapping("/SupprimerVoyage/{id}")
    public String deleteVoyage(@PathVariable("id") Long id)
    {
    	adminService.deleteVoyageById(id);
    	return "redirect:/listvoyage";
    }
    //*************** Hotêls*************************
    @GetMapping("/listhotels")
    public String AfficherHotels(Model model)
	{
		List<Hotel> hotels = adminService.getAllHotels();
		model.addAttribute("hotels", hotels);
		return "listhotels";
	}
    @GetMapping("/AjoutHotel")
    public String AddHotel()
    {
    	return "/addHotel.html";
    }
   
    @PostMapping("/addH")
    public String savehotel(@RequestParam("imageHotel") MultipartFile imageHotel,
    		@RequestParam("nomHotel") String nomHotel,
    		@RequestParam("type") String type,
    		@RequestParam("ville") String ville,
    		@RequestParam("descriptionHotel") String descriptionHotel,
    		@RequestParam("prixHotel") double prix
    		)
    		
    {
    	
    	adminService.savehotelToDB(imageHotel, nomHotel, type, ville, descriptionHotel,prix);
    	return "redirect:/listhotels";
    }
    @GetMapping("/SupprimerHotel/{id}")
    public String deleteHotel(@PathVariable("id") Long id)
    {
    	adminService.deleteHotelById(id);
    	return "redirect:/listhotels";
    }
    //modif
    @PostMapping ("/changeNameHotel/{id}" )
    public  String  changeHname(@PathVariable("id") Long  id ,@RequestParam( "newHname" )String nom )
    {
     adminService.changeNameHotel(id, nom);
    
     return "redirect:/listhotels";
    }
    @PostMapping ("/changePrixHotel/{id}" )
    public  String  changePrix(@PathVariable("id") Long  id ,@RequestParam( "newHprix" ) double prix )
    {
     adminService.changePrixHotel(id, prix);
    
     return "redirect:/listhotels";
    }
    @PostMapping ("/changeDescriptionHotel/{id}" )
    public  String  changeDescr(@PathVariable("id") Long  id ,@RequestParam( "newHDescription" ) String desc )
    {
     adminService.changeDescriptionHotel(id, desc);
    
     return "redirect:/listhotels";
    }
  //*************** Omra*************************
    @GetMapping("/listomra")
    public String AfficherOmra(Model model)
	{
		List<Omra> omra = adminService.getAllOmra();
		model.addAttribute("omra", omra);
		return "listomra";
	}
    @GetMapping("/AjoutOmra")
    public String AddOmra()
    {
    	return "/addOmra.html";
    }
   
    @PostMapping("/addO")
    public String saveOmra(
    		@RequestParam("villeDest") String villeDest,
    		@RequestParam("prixOmra") double prix,
    		@RequestParam("dateAOmra") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateAO,
    		@RequestParam("dateDOmra") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateDO
    		)
    		
    {
    	
    	adminService.saveOmraToDB( villeDest,prix, dateAO,dateAO);
    	return "redirect:/listomra";
    }
    
    @GetMapping("/SupprimerOmra/{id}")
    public String deleteOmra(@PathVariable("id") Long id)
    {
    	adminService.deleteOmraById(id);
    	return "redirect:/listomra";
    }
    //*************** Vol*************************
    @GetMapping("/listvol")
    public String AfficherVol(Model model)
	{
		List<Billet> billet = adminService.getAllVols();
		model.addAttribute("billet", billet);
		return "listvol";
	}
    @GetMapping("/AjoutVol")
    public String Addvol()
    {
    	return "/addVol.html";
    }
   
   @PostMapping("/addVol")
    public String saveVol(
    		@RequestParam("VdepartB") String VdepartB,
    		@RequestParam("destinationB") String destinationB,
    		@RequestParam("compagnie") String compagnie,
    		@RequestParam("prixB") double prixB,
    		@RequestParam("dateAB") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateAB,
    		@RequestParam("dateDB") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateDB,
    		@RequestParam("timeDB") @DateTimeFormat(pattern="HH:mm") Date timeDB,
    		@RequestParam("timeAB") @DateTimeFormat(pattern="HH:mm") Date timeAB
    		)
    		
    {
    	
    	adminService.saveVolToDB( VdepartB,destinationB,compagnie,prixB, dateAB, dateDB,timeDB,timeAB);
    	return "redirect:/listvol";
    }
   
   
   @GetMapping("/SupprimerVol/{id}")
   public String deleteVol(@PathVariable("id") Long id)
   {
   	adminService.deleteVolById(id);
   	return "listvol";
   }
 
 //Clients
   @GetMapping("/listClients")
   public String AfficherClient(Model model)
   	{
   		List<Utilisateurs> clients = userService.getAllUsers();
   		model.addAttribute("clients", clients);
   		return "listClients";
   	}

}