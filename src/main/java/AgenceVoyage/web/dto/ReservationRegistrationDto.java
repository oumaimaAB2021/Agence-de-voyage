package AgenceVoyage.web.dto;
//Data transfert object, des objets qui contiennent des données et il n'ont pas un logique métier

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationRegistrationDto {
	private Long uid,numOffre;
	private int nbrJour, nbrAdulte,nbrEnfant,nbrChambre;
	private Date dateReservation;
	private String villeOmra,chambreOmra;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date debut, fin;
	
	
	public ReservationRegistrationDto( int nbrJour, int nbrAdulte, int nbrEnfant,
			Date dateReservation,Long uid, Long numOffre) {
		super();
		this.uid = uid;
		this.numOffre = numOffre;
		this.nbrJour = nbrJour;
		this.nbrAdulte = nbrAdulte;
		this.nbrEnfant = nbrEnfant;
		this.dateReservation = dateReservation;
		
	}
	
	
	public ReservationRegistrationDto(Long uid, Long numOffre, int nbrJour, int nbrAdulte, int nbrEnfant,
			Date dateReservation, String villeOmra, String chambreOmra) {
		super();
		this.uid = uid;
		this.numOffre = numOffre;
		this.nbrJour = nbrJour;
		this.nbrAdulte = nbrAdulte;
		this.nbrEnfant = nbrEnfant;
		this.dateReservation = dateReservation;
		this.villeOmra = villeOmra;
		this.chambreOmra = chambreOmra;
	}
	//pour hotel
	public ReservationRegistrationDto(Long uid, Long numOffre, int nbrChambre, int nbrAdulte, int nbrEnfant,Date debut,Date fin,
	Date dateReservation, String chambreOmra) {
	super();
	this.uid = uid;
	this.numOffre = numOffre;
	this.nbrChambre = nbrChambre;
	this.nbrAdulte = nbrAdulte;
	this.nbrEnfant = nbrEnfant;
	this.dateReservation = dateReservation;
	this.chambreOmra = chambreOmra;
	this.debut= debut;
	this.fin = fin;
	}

	public ReservationRegistrationDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getVilleOmra() {
		return villeOmra;
	}


	public void setVilleOmra(String villeOmra) {
		this.villeOmra = villeOmra;
	}


	public String getChambreOmra() {
		return chambreOmra;
	}


	public void setChambreOmra(String chambreOmra) {
		this.chambreOmra = chambreOmra;
	}


	public Long getUid() {
		return uid;
	}


	public void setUid(Long uid) {
		this.uid = uid;
	}


	public Long getNumOffre() {
		return numOffre;
	}
	public void setNumOffre(Long numOffre) {
		this.numOffre = numOffre;
	}
	public int getNbrJour() {
		return nbrJour;
	}
	public void setNbrJour(int nbrJour) {
		this.nbrJour = nbrJour;
	}
	public int getNbrAdulte() {
		return nbrAdulte;
	}
	public void setNbrAdulte(int nbrAdulte) {
		this.nbrAdulte = nbrAdulte;
	}
	public int getNbrEnfant() {
		return nbrEnfant;
	}
	public void setNbrEnfant(int nbrEnfant) {
		this.nbrEnfant = nbrEnfant;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}


	public int getNbrChambre() {
		return nbrChambre;
	}


	public void setNbrChambre(int nbrChambre) {
		this.nbrChambre = nbrChambre;
	}


	public Date getDebut() {
		return debut;
	}


	public void setDebut(Date debut) {
		this.debut = debut;
	}


	public Date getFin() {
		return fin;
	}


	public void setFin(Date fin) {
		this.fin = fin;
	}
	
	
	
	
}
