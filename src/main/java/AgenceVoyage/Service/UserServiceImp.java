package AgenceVoyage.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import AgenceVoyage.repository.UserRepository;
import AgenceVoyage.Model.Role;
import AgenceVoyage.Model.Utilisateurs;
import AgenceVoyage.web.dto.UserRegistrationDto;
@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository UserRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImp(AgenceVoyage.repository.UserRepository userRepository) {
		super();
		UserRepository = userRepository;
	}
	//Création d'un objet utilisateurs et récupération des données
	@Override
	public Utilisateurs save(UserRegistrationDto registrationDto) {
		
		// TODO Auto-generated method stub
		
		Utilisateurs user=new Utilisateurs(registrationDto.getCin(),registrationDto.getNom(),
		registrationDto.getPrenom(),registrationDto.getEmail(),
		passwordEncoder.encode(registrationDto.getMotdepasse()),registrationDto.getAdresse(),  Arrays.asList(new Role("ROLE_USER")));		
		
		return UserRepository.save(user);
		
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Utilisateurs user= UserRepository.findByEmail(username);
		
	
		if(user==null) {
			throw new UsernameNotFoundException("Email ou mot de passe invalide");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getMotdepasse(), mapRolesToAuthorities(user.getRoles()));
		
	}
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	//Affichage users dans espace admin
	@Override
	public List<Utilisateurs> getAllUsers() {
		return UserRepository.findAllUsers();
	}
	

	
}
