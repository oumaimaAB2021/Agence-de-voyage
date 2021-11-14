package AgenceVoyage.Model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@DiscriminatorValue("Billet")
public class Billet extends Offre{
	private String Compagnie;
	@Temporal(TemporalType.DATE)
	private Date dateDepart;
	@Temporal(TemporalType.TIME)
	private Date HeureDepart;
	@Temporal(TemporalType.DATE)
	private Date dateArrivee;
	@Temporal(TemporalType.TIME)
	private Date HeureArrivee;
	
	
	public Billet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Billet(String villeDepart, String villeArrive, double prix, Date dateDebut, Date dateExpedition,
			Collection<Reservation> reservations, String compagnie, Date dateDepart, Date dateArrivee) {
		super(villeDepart, villeArrive, prix, dateDebut, dateExpedition, reservations);
		Compagnie = compagnie;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
	}








	public Date getDateDepart() {
		return dateDepart;
	}


	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}


	public Date getDateArrivee() {
		return dateArrivee;
	}


	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public String getCompagnie() {
		return Compagnie;
	}
	public void setCompagnie(String compagnie) {
		Compagnie = compagnie;
	}



	public Date getHeureDepart() {
		return HeureDepart;
	}



	public void setHeureDepart(Date heureDepart) {
		HeureDepart = heureDepart;
	}



	public Date getHeureArrivee() {
		return HeureArrivee;
	}



	public void setHeureArrivee(Date heureArrivee) {
		HeureArrivee = heureArrivee;
	}
	
	
	

}
