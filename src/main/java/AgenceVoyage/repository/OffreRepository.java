package AgenceVoyage.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import AgenceVoyage.Model.Billet;
import AgenceVoyage.Model.Hotel;
import AgenceVoyage.Model.Offre;
import AgenceVoyage.Model.Omra;
import AgenceVoyage.Model.Reservation;
import AgenceVoyage.Model.VoyageOrganise;

@Repository
public interface OffreRepository extends JpaRepository <Offre, Long>{
	Offre findByvilleArrive( String ville);
	List<Offre> findAll();
	//Affichage des vols dispo par ville (départ et destination)
	@Query("SELECT b from Billet b where b.villeDepart like %?1% or b.villeArrive like %?2% or b.Compagnie like %?3%")
	List<Billet> findByVille(String villeDepart, String villeArrive, String Compagnie);
	//Affichage des villes dispo 
	@Query("SELECT distinct(b.villeArrive) from Billet b")
	List findVieDispo();
	//Compagnie aérienne dispo
	@Query("SELECT distinct(b.Compagnie) from Billet b")
	List findCompagnieDispo();
	Offre findByNumOffre(Long num);
	
	@Query("Select b.dateDepart from Billet b left join Offre o on b.numOffre=o.numOffre where o.numOffre=?1")
	//@Query("SELECT b.dateDepart from Billet b JOIN Offre o where o.numOffre=?1")
	Date findByDateDepart(Long num);
	@Query("Select b.dateArrivee from Billet b left join Offre o on b.numOffre=o.numOffre where o.numOffre=?1")
	Date findByDateArrivee(Long num);
	/*@Query("Select * from Billet b left join Offre o on b.numOffre=o.numOffre where o.numOffre=?1")
	Billet findByChoix(Long num);*/
	@Query("Select o from Omra o")
	List<Omra> findOmra();
	//Utiliisé dans esace admin
	@Query("Select v from VoyageOrganise v")

	List<VoyageOrganise> findAllVoyagesO();

	@Query("Select h from Hotel h")
	List<Hotel> findHotel();
	@Query("Select b from Billet b")
	List<Billet> findVols();
	
	@Query("SELECT COUNT(o) FROM Offre o ")
	public int CountNbrOffres();
}


