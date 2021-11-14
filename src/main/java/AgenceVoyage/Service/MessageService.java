package AgenceVoyage.Service;

import java.util.List;

import AgenceVoyage.Model.Billet;
import AgenceVoyage.Model.Message;

public interface MessageService {
	void saveMessageToDB(String nom, String email, String objet, String message);
	public List<Message> getAllMessages();
}
