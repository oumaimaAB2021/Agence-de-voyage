package AgenceVoyage.web.dto;

public class UserRegistrationDto {
	private String cin;
	
	private String nom;
	
	private String email;
	
	private String prenom;
	
	private String adresse;
	
	private String motdepasse;
	
	public UserRegistrationDto(String cin, String nom, String email, String prenom, String adresse, String motdepasse) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.email = email;
		this.prenom = prenom;
		this.adresse = adresse;
		this.motdepasse = motdepasse;
	}
	
	public UserRegistrationDto() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
}
