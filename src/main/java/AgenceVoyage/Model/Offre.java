package AgenceVoyage.Model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table
//heritage
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeOffre")
public class Offre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numOffre;
	public String villeDepart;
	public String villeArrive;
	private double prix;
	@Temporal(TemporalType.DATE)
	public Date dateDebut;
	@Temporal(TemporalType.DATE)
	public Date dateExpedition;
	
	//jointure avec reservation
		@OneToMany(mappedBy="offre",fetch=FetchType.LAZY)
		private Collection<Reservation> reservations;
	
	
	public Offre(String villeDepart, String villeArrive, double prix) {
			super();
			this.villeDepart = villeDepart;
			this.villeArrive = villeArrive;
			this.prix = prix;
		}
	public Offre(String villeDepart, String villeArrive, double prix, Date dateDebut, Date dateExpedition,
				Collection<Reservation> reservations) {
			super();
			this.villeDepart = villeDepart;
			this.villeArrive = villeArrive;
			this.prix = prix;
			this.dateDebut = dateDebut;
			this.dateExpedition = dateExpedition;
			this.reservations = reservations;
		}
	public Date getDateDebut() {
			return dateDebut;
		}
		public void setDateDebut(Date dateDebut) {
			this.dateDebut = dateDebut;
		}
		public Date getDateExpedition() {
			return dateExpedition;
		}
		public void setDateExpedition(Date dateExpedition) {
			this.dateExpedition = dateExpedition;
		}
	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getNumOffre() {
		return numOffre;
	}
	public void setNumOffre(Long numReservation) {
		this.numOffre = numReservation;
	}
	
	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	public String getVilleArrive() {
		return villeArrive;
	}
	public void setVilleArrive(String villeArrive) {
		this.villeArrive = villeArrive;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	

}
