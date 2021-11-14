package AgenceVoyage.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import AgenceVoyage.Model.Message;
import AgenceVoyage.Model.VoyageOrganise;
import AgenceVoyage.repository.MessageRepository;

@Service
public class MessageServiceImp  implements MessageService{
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public void saveMessageToDB(String nom, String email, String objet, String message) {
		
			Message mess=new Message();
			mess.setNom(nom);
			mess.setEmail(email);
			mess.setObjet(objet);
			mess.setMessage(message);		  
		  
		    messageRepository.save(mess);
		}

	@Override
	public List<Message> getAllMessages() {
		return messageRepository.findMessages();
	}


	}


