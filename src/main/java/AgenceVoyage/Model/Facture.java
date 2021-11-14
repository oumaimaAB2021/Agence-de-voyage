package AgenceVoyage.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Facture {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFacture; 

	
	
	private Reservation reservation;
	@OneToOne
	private Offre Monoffre;	
	private Utilisateurs user;
	
	public Facture(Reservation reservation, Offre monoffre, Utilisateurs user) {
		super();
		this.reservation = reservation;
		Monoffre = monoffre;
		this.user = user;
	}
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Offre getMonoffre() {
		return Monoffre;
	}
	public void setMonoffre(Offre monoffre) {
		Monoffre = monoffre;
	}
	public Utilisateurs getUser() {
		return user;
	}
	public void setUser(Utilisateurs user) {
		this.user = user;
	}

	
	






	
}
