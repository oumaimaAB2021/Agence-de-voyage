package AgenceVoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import AgenceVoyage.Model.Offre;
import AgenceVoyage.Model.Reservation;
import AgenceVoyage.Model.Utilisateurs;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Long>{
@Query("SELECT r from Reservation r where r.idUtilisateur=?1 and r.idOffre=?2 ")
Reservation findR(Long id,Long num);
@Query("SELECT COUNT(r) FROM Reservation r  ")
public int CountNbrReservation();
}
