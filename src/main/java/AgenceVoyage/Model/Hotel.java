package AgenceVoyage.Model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity

@DiscriminatorValue("Hôtel")
public class Hotel extends Offre{
	
	
	private String type;
	private String ville;
	private String nomHotel;
	private String descriptionHotel;
	@Lob
	@Column(columnDefinition="MEDIUMBLOB")
	private String imageHotel;


	public Hotel(String villeDepart, String villeArrive, double prix, Date dateDebut, Date dateExpedition,
	Collection<Reservation> reservations, String type, String ville, String nomHotel,
	String descriptionHotel, String imageHotel) {
	super(villeDepart, villeArrive, prix, dateDebut, dateExpedition, reservations);

	this.type = type;
	this.ville = ville;
	this.nomHotel = nomHotel;
	this.descriptionHotel = descriptionHotel;
	this.imageHotel = imageHotel;
	}

	public Hotel() {
	super();
	// TODO Auto-generated constructor stub
	}
	
	
	public String getDescriptionHotel() {
		return descriptionHotel;
	}

	public void setDescriptionHotel(String descriptionHotel) {
		this.descriptionHotel = descriptionHotel;
	}

	public String getImageHotel() {
		return imageHotel;
	}

	public void setImageHotel(String imageHotel) {
		this.imageHotel = imageHotel;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	
	

}
