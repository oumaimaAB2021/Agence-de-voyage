package AgenceVoyage.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import AgenceVoyage.Model.Utilisateurs;
import AgenceVoyage.Service.UserService;
import AgenceVoyage.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
private UserService userService;

public UserRegistrationController(UserService userService) {
	super();
	this.userService = userService;
}

//Cette méthode handle http get request
@GetMapping
public String ShowRegistrationForm() {
	return "registration";
	
}
//C'est ce user qu'on a utilisé en registration.html
@ModelAttribute("user")
public UserRegistrationDto UserRegistrationDto() {
	return new UserRegistrationDto();
}
//Cette méthode handle http post request
@PostMapping
public  String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
	userService.save(registrationDto);
	return "redirect:/registration?success";
	
}




}
