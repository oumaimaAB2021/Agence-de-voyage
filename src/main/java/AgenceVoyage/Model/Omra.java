package AgenceVoyage.Model;


import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Table;


@Entity

@DiscriminatorValue("Omra")
public class Omra  extends Offre{

public Omra() {
	super();
	// TODO Auto-generated constructor stub
}

public Omra(String villeDepart, String villeArrive, double prix, Date dateDebut, Date dateExpedition,
		Collection<Reservation> reservations) {
	super(villeDepart, villeArrive, prix, dateDebut, dateExpedition, reservations);
	// TODO Auto-generated constructor stub
}





 
}
