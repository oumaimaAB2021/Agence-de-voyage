package AgenceVoyage.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import AgenceVoyage.Model.Message;
import AgenceVoyage.Model.VoyageOrganise;
import AgenceVoyage.Service.MessageServiceImp;
@Controller
public class MessageController {
	@Autowired
	private MessageServiceImp messageService;
	
	@GetMapping("/avis")
	public String showVoyage(Model model)
	{
		List<Message> messages = messageService.getAllMessages();
		model.addAttribute("messages", messages);
		return "avis";
	}
	
    @PostMapping("/addM")
    public String savevoyage(
    		@RequestParam("nom") String nom,
    		@RequestParam("email") String email,
    		@RequestParam("objet") String objet,
    		@RequestParam("message") String message)
    		
    {
    	
    	messageService.saveMessageToDB(nom, email, objet, message);
    	return "services";
    }
    
    
}
