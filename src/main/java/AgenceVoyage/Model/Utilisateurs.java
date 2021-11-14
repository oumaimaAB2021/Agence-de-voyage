package AgenceVoyage.Model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="Utilisateurs",uniqueConstraints =@UniqueConstraint(columnNames={"cin","email"}))
public class Utilisateurs implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Uid;
	
	//jointure avec reservation
		@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
		private Collection<Reservation> reservations;
	
	
		
	
	public Utilisateurs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String cin;
	
	private String nom;
	
	private String email;
	
	private String prenom;
	
	private String adresse;
	
	private String motdepasse;
	
	//private Collection<Role> roles;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "uid"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "id"))
	
	private Collection<Role> roles;
	
	
	public Utilisateurs(String cin, String nom, String prenom,String email,String password, String adresse,Collection<Role> roles) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.email = email;
		this.prenom = prenom;
		this.adresse = adresse;
		motdepasse = password;
		this.roles=roles;
	}
	


	public Collection<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}







	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public Long getUid() {
		return Uid;
	}
	public void setUid(Long uid) {
		Uid = uid;
	}
	
	
	
}
