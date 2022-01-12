package fr.diginamic.tpspringjpa05.controllerweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	public HomeController() {
		
	}
	
	@GetMapping
	public String home(Model model) {
		String dtitre = "Bonjour !";
		model.addAttribute("titre", dtitre);
		return "home";
	}

}
