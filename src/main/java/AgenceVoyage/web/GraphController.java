package AgenceVoyage.web;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import AgenceVoyage.Service.GraphiqueServiceImp;

@Controller
public class GraphController {
	//Calcul des nombres des reservations, offres, clients
	
	
	@Autowired
	private GraphiqueServiceImp graphService;

	
	
	
	
	@GetMapping("/graphique")
	public String Graphique(Model model) {
		Map<String,Integer> surveymap=new LinkedHashMap<>();
		int nbrReservations=graphService.CountAllReservations();
		int  nbrOffres=graphService.CountAllOffres();
		int  nbrClients=graphService.CountAllClients();
		surveymap.put("Clients", nbrClients);
		surveymap.put("Offres", nbrOffres);
		surveymap.put("Reservations", nbrReservations);
		
		//surveymap.put("Hôtels", 60);
		model.addAttribute("surveymap",surveymap);
		return "graph";
	}
}
