package AgenceVoyage.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AgenceVoyage.repository.OffreRepository;
import AgenceVoyage.repository.ReservationRepository;
import AgenceVoyage.repository.UserRepository;


@Service
public class GraphiqueServiceImp implements GraphiqueService{
	@Autowired
	private OffreRepository offreRepository;
	@Autowired
	ReservationRepository ReservationRepository;
	
	@Autowired
	UserRepository UserRepository;


	@Override
	public int CountAllOffres() {
		return offreRepository.CountNbrOffres();
	}


	@Override
	public int CountAllClients() {
		return UserRepository.CountNbrUsers();
	}


	@Override
	public int CountAllReservations() {
		return ReservationRepository.CountNbrReservation();
	}



	
 
	


	}
	


