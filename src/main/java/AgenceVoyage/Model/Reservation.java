package AgenceVoyage.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;

import AgenceVoyage.repository.UserRepository;

@Entity
@Table
public class Reservation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReservation;   
	private Long idUtilisateur, idOffre;
	private int nbrJour, nbrAdulte,nbrEnfant,nbrChambre ;
	private Date dateReservation;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date debut, fin;
	private String villeOmra,chambreOmra;
	
	
	//jointure avec utilisateur
		@ManyToOne
		@JoinColumn(name="uid")
		private Utilisateurs utilisateur;
		
		//jointure avec offre
				@ManyToOne
				@JoinColumn(name="num_offre")
				private Offre offre;
				
				//jointure avec Facture
				@ManyToOne
				@JoinColumn(name="idFacture")
				private Facture facture;
				


			public Reservation( int nbrJour, int nbrAdulte, int nbrEnfant,
				Date dateReservation,Long idUtilisateur, Long idOffre) {
			super();
			this.idUtilisateur = idUtilisateur;
			this.idOffre = idOffre;
			this.nbrJour = nbrJour;
			this.nbrAdulte = nbrAdulte;
			this.nbrEnfant = nbrEnfant;
			this.dateReservation = dateReservation;
			
		}



				public Reservation() {
					super();
					// TODO Auto-generated constructor stub
				}



				public Reservation(Long idUtilisateur, Long idOffre, int nbrJour, int nbrAdulte, int nbrEnfant,
						Date dateReservation, String villeOmra, String chambreOmra) {
					super();
					this.idUtilisateur = idUtilisateur;
					this.idOffre = idOffre;
					this.nbrJour = nbrJour;
					this.nbrAdulte = nbrAdulte;
					this.nbrEnfant = nbrEnfant;
					this.dateReservation = dateReservation;
					this.villeOmra = villeOmra;
					this.chambreOmra = chambreOmra;
				}
//Pour Hotel
				public Reservation(Long idUtilisateur, Long idOffre,int nbrChambre, int nbrAdulte, int nbrEnfant,Date debut,Date fin,
						Date dateReservation, String chambreOmra) {
						super();
						this.idUtilisateur = idUtilisateur;
						this.idOffre = idOffre;
						this.nbrChambre = nbrChambre;
						this.nbrAdulte = nbrAdulte;
						this.nbrEnfant = nbrEnfant;
						this.dateReservation = dateReservation;
						this.chambreOmra = chambreOmra;
						this.debut= debut;
						this.fin = fin;
						}

				public Long getIdOffre() {
					return idOffre;
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



				public Facture getFacture() {
					return facture;
				}



				public void setFacture(Facture facture) {
					this.facture = facture;
				}



				public void setIdOffre(Long idOffre) {
					this.idOffre = idOffre;
				}



				public Date getDateReservation() {
					return dateReservation;
				}



				public void setDateReservation(Date dateReservation) {
					this.dateReservation = dateReservation;
				}



				public Long getIdReservation() {
					return idReservation;
				}



				public void setIdReservation(Long idReservation) {
					this.idReservation = idReservation;
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



				public Utilisateurs getUtilisateur() {
					return utilisateur;
				}



				public void setUtilisateur(Utilisateurs utilisateur) {
					this.utilisateur = utilisateur;
				}



				public Offre getOffre() {
					return offre;
				}



				public void setOffre(Offre offre) {
					this.offre = offre;
				}



				public Long getIdUtilisateur() {
					return idUtilisateur;
				}



				public void setIdUtilisateur(Long idUtilisateur) {
					this.idUtilisateur = idUtilisateur;
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
