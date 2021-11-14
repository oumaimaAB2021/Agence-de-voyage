package AgenceVoyage.Service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import AgenceVoyage.Model.Reservation;
import AgenceVoyage.repository.OffreRepository;
import AgenceVoyage.repository.ReservationRepository;
import AgenceVoyage.repository.UserRepository;
import AgenceVoyage.web.dto.ReservationRegistrationDto;
import AgenceVoyage.web.ReservationRegistrationController;

@Service
public class ReservationServiceImp implements ReservationService{
	
	@Autowired 
	ReservationRepository reservationRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	OffreRepository offreRepository;
	
	

	public ReservationServiceImp(ReservationRepository reservationRepository, UserRepository userRepository,OffreRepository offreRepository) {
		super();
		this.reservationRepository = reservationRepository;
		this.userRepository = userRepository;
		this.offreRepository = offreRepository;
		
	}
	
	@Override
	public Reservation save(ReservationRegistrationDto reservationDto) {
		// TODO Auto-generated method stub
		//recupérer id du client courant
	Long id=userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getUid();
	Long idoffre=AgenceVoyage.web.ReservationRegistrationController.num;
	
	Reservation reservation= new Reservation(reservationDto.getNbrJour(),reservationDto.getNbrAdulte(),reservationDto.getNbrEnfant(),
			new Date(),id,idoffre);
		return reservationRepository.save(reservation);

	}

	@Override
	public Reservation reserverOmra(ReservationRegistrationDto reservationDto) {
		//recupérer id du client courant
		Long id=userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getUid();
		Long idoffre=AgenceVoyage.web.ReservationRegistrationController.numOmra;
		System.out.println("mmmm: "+idoffre);
			
		Reservation reservation2= new Reservation(id,idoffre,reservationDto.getNbrJour(),reservationDto.getNbrAdulte(), reservationDto.getNbrEnfant(),
				new Date(), reservationDto.getVilleOmra(), reservationDto.getChambreOmra());
	
			return reservationRepository.save(reservation2);
	}
	
	@Override
	//pour hotel
	public Reservation reserverhotel(ReservationRegistrationDto reservationDto) {
	//recupérer id du client courant
	Long id=userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getUid();
	Long idoffre=AgenceVoyage.web.ReservationRegistrationController.numHotel;

	Reservation reservation3= new Reservation(id,idoffre,reservationDto.getNbrChambre(),reservationDto.getNbrAdulte(), reservationDto.getNbrEnfant(),
	reservationDto.getDebut(),reservationDto.getFin(),new Date(), reservationDto.getChambreOmra());

	return reservationRepository.save(reservation3);
	}


	//pour voyage
	@Override
	public Reservation reserverVoyage(ReservationRegistrationDto reservationDto) {
	// TODO Auto-generated method stub
	//recupérer id du client courant
	Long id=userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getUid();
	Long idoffre=AgenceVoyage.web.ReservationRegistrationController.numVoyage;

	Reservation reservation4= new Reservation(reservationDto.getNbrJour(),reservationDto.getNbrAdulte(),reservationDto.getNbrEnfant(),
	new Date(),id,idoffre);
	return reservationRepository.save(reservation4);

	}
}