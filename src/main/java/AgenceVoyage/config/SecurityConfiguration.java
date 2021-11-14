package AgenceVoyage.config;
import AgenceVoyage.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//Permet d'intègrer spring security with spring ioc
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
@Autowired
private UserService userService;
	
	@Bean
public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	
}

//Intégration de jpa et hibernate en spring Security
@Bean
public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    auth.setUserDetailsService(userService);
    auth.setPasswordEncoder(passwordEncoder());
    return auth;
}
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider());
}
	@Override
protected void configure(HttpSecurity http) throws Exception
{
	//Accèes à des pages, login page, logout,....
	http.authorizeRequests().antMatchers("/admin","/graphique","/listvoyage","/add","/addV","/listhotels",
			"/AjoutHotel","/addH","/listomra","/AjoutOmra","/addO","/listvol"
			,"/AjoutVol","/addVol","/listClients"
			).hasRole("ADMIN")
	
	.antMatchers(
			"/registration**",
			"/js/**",
			"/css/**",
			"/img/**").permitAll()
	.anyRequest().authenticated()
	.and()
	.formLogin()
	.loginPage("/login").defaultSuccessUrl("/services")
	.permitAll()
	.and()
	.logout()
	.invalidateHttpSession(true)
	.clearAuthentication(true)
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	.logoutSuccessUrl("/login?logout")
	.permitAll();
			
}
}
