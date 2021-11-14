package AgenceVoyage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import AgenceVoyage.Model.Reservation;
import AgenceVoyage.Model.Utilisateurs;
@Repository
public interface UserRepository extends JpaRepository <Utilisateurs, Long>{
	Utilisateurs findByEmail(String email);
	@Query("Select u from Utilisateurs u")
	List<Utilisateurs> findAllUsers();
	@Query("SELECT COUNT(u) FROM Utilisateurs u ")
	public int CountNbrUsers();
}
