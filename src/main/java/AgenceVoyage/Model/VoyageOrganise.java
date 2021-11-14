package AgenceVoyage.Model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@DiscriminatorValue("VoyageOrganisé")
public class VoyageOrganise  extends Offre{
private String descriptionVoyage;
private String titreVoyage;

@Lob
@Column(columnDefinition="MEDIUMBLOB")
private String imageVoyage;





public VoyageOrganise(String villeDepart, String villeArrive, double prix, String descriptionVoyage, String titreVoyage,
		String imageVoyage) {
	super(villeDepart, villeArrive, prix);
	this.descriptionVoyage = descriptionVoyage;
	this.titreVoyage = titreVoyage;
	this.imageVoyage = imageVoyage;
}



public VoyageOrganise() {
super();
// TODO Auto-generated constructor stub
}

public String getDescriptionVoyage() {
	return descriptionVoyage;
}

public void setDescriptionVoyage(String descriptionVoyage) {
	this.descriptionVoyage = descriptionVoyage;
}

public String getImageVoyage() {
	return imageVoyage;
}

public void setImageVoyage(String imageVoyage) {
	this.imageVoyage = imageVoyage;
}



public String getTitreVoyage() {
	return titreVoyage;
}



public void setTitreVoyage(String titreVoyage) {
	this.titreVoyage = titreVoyage;
}



}