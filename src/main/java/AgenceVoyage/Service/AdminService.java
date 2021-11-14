package AgenceVoyage.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import AgenceVoyage.Model.Billet;
import AgenceVoyage.Model.Hotel;
import AgenceVoyage.Model.Omra;
import AgenceVoyage.Model.VoyageOrganise;
import AgenceVoyage.repository.OffreRepository;


public interface  AdminService {

	public void saveOffreToDB(MultipartFile file, String titre, String Description, double prix, String destination, Date dateD, Date dateA,String Vdepart); 
	public void savehotelToDB(MultipartFile imageHotel, String nomHotel, String type, String ville, String descriptionHotel,double prix); 
	public void saveOmraToDB( String villeDest,double prix, Date dateAO, Date dateAO2);
	public void saveVolToDB( String VdepartB,String destinationB,String compagnie, double prixB, Date dateAB,Date dateDB, Date timeDB,Date timeAB);
	public List<VoyageOrganise> getAllVoyages();
	public List<Hotel> getAllHotels();
	public List<Omra> getAllOmra();
	public List<Billet> getAllVols();
	
	public void deleteHotelById(Long id);
	public void deleteVoyageById(Long id);
	public void deleteOmraById(Long id);
	public void deleteVolById(Long id);	
	 //Modification
	public void changeNameHotel(Long  id ,String  name);  
	public void changePrixHotel(Long  id ,double prix);  
	public void changeDescriptionHotel(Long  id ,String  name);  

}
