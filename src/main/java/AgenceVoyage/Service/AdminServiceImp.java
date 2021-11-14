package AgenceVoyage.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import AgenceVoyage.Model.Billet;
import AgenceVoyage.Model.Hotel;
import AgenceVoyage.Model.Omra;
import AgenceVoyage.Model.VoyageOrganise;
import AgenceVoyage.repository.OffreRepository;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AdminServiceImp implements AdminService{
	@Autowired
	private OffreRepository offreRepository;
	
	//Voyages organisés
	@Override
	public void saveOffreToDB(MultipartFile file, String titre, String Description, double prix, String destination, Date dateD, Date dateA, String Vdepart) {
		VoyageOrganise agence=new VoyageOrganise();
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		try {
			/*Transformation de l'image en String */
			agence.setImageVoyage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		agence.setDescriptionVoyage(Description);
		
		agence.setTitreVoyage(titre);
	    
	    agence.setPrix(prix);
	    agence.setVilleArrive(destination);
	    agence.setDateDebut(dateD);
	    System.out.println(dateA);	  
	    agence.setDateExpedition(dateA);
	    agence.setVilleDepart(Vdepart);
	    offreRepository.save(agence);
	}


	@Override
	public List<VoyageOrganise> getAllVoyages() {
		// TODO Auto-generated method stub
		return offreRepository.findAllVoyagesO();
	}

	 //Hôtels
	@Override
	public void savehotelToDB(MultipartFile imageHotel, String nomHotel, String type, String ville,
			String descriptionHotel,double prix) {
	Hotel hotel=new Hotel();
		
		String fileName = StringUtils.cleanPath(imageHotel.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		try {
			/*Transformation de l'image en String */
			hotel.setImageHotel(Base64.getEncoder().encodeToString(imageHotel.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hotel.setNomHotel(nomHotel);
		hotel.setType(type);
		hotel.setVille(ville);
		hotel.setDescriptionHotel(descriptionHotel);
		hotel.setPrix(prix);
		
	    offreRepository.save(hotel);
		
	}


	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return offreRepository.findHotel();
	}
	//Modification
	@Override
	public void changeNameHotel(Long id, String name) 
		   {
		    Hotel h =  new  Hotel();
		    h = (Hotel) offreRepository.findById(id).get();
		   
		    h.setNomHotel(name);
		    offreRepository.save(h);    
		   }
	
	@Override
	public void changePrixHotel(Long id, double prix) {
		Hotel h =  new  Hotel();
	    h = (Hotel) offreRepository.findById(id).get();
	   
	    h.setPrix(prix);
	    offreRepository.save(h); 
		
	}


	@Override
	public void changeDescriptionHotel(Long id, String desc) {
		Hotel h =  new  Hotel();
	    h = (Hotel) offreRepository.findById(id).get();
	   
	    h.setDescriptionHotel(desc);
	    offreRepository.save(h); 
		
	}
//Omra
	@Override
	public void saveOmraToDB( String villeDest,double prix, Date dateAO, Date dateDO) {
		Omra omra=new Omra();
		
		
		omra.setDateDebut(dateDO);
		omra.setDateExpedition(dateAO);
		omra.setVilleArrive(villeDest);
		omra.setPrix(prix);
	    offreRepository.save(omra);
		
	}


	@Override
	public List<Omra> getAllOmra() {
		// TODO Auto-generated method stub
		return offreRepository.findOmra();
	}

	//Vols
	@Override
	public void saveVolToDB(String VdepartB, String destinationB, String compagnie, double prixB, Date dateAB,
			Date dateDB, Date timeDB, Date timeAB) {
		Billet billet=new Billet();
		billet.setVilleDepart(VdepartB);
		billet.setVilleArrive(destinationB);
		billet.setCompagnie(compagnie);
		billet.setPrix(prixB);
		billet.setDateDepart(dateDB);
		billet.setDateArrivee(dateAB);
		billet.setHeureDepart(timeDB);
		billet.setHeureArrivee(timeAB);
		offreRepository.save(billet);
	}

	@Override
	public List<Billet> getAllVols() {
		
		return offreRepository.findVols();
	}


	public void deleteHotelById(Long id) {
		offreRepository.deleteById(id);
		
	}


	@Override
	public void deleteVoyageById(Long id) {
		offreRepository.deleteById(id);
		
	}


	@Override
	public void deleteOmraById(Long id) {
		offreRepository.deleteById(id);
		
	}


	@Override
	public void deleteVolById(Long id) {
		offreRepository.deleteById(id);
		
	}


	


	
		



	
 
	


	}
	


