package AgenceVoyage.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMessage; 
	private String nom,email,objet,message;
	
	

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String nom, String email, String objet, String message) {
		super();
		this.nom = nom;
		this.email = email;
		this.objet = objet;
		this.message = message;
	}

	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
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

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
