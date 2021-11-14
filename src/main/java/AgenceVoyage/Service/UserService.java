package AgenceVoyage.Service;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import AgenceVoyage.Model.Utilisateurs;
import AgenceVoyage.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
		Utilisateurs save(UserRegistrationDto registrationDto);

		List<Utilisateurs> getAllUsers();

		
		
	
}
