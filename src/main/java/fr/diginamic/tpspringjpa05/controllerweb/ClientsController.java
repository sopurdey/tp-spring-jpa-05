package fr.diginamic.tpspringjpa05.controllerweb;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.tpspringjpa05.model.Client;
import fr.diginamic.tpspringjpa05.repository.iCrudClient;

@Controller
@RequestMapping("/client")
public class ClientsController {
	@Autowired
	iCrudClient cc;
	
	private String message;

	public ClientsController() {

	}

	@GetMapping("/clients")
	public String findAll(Model model) {
		model.addAttribute("clients", (List<Client>) cc.findAll());
		model.addAttribute("titre", "Liste de clients");
		return "clients/liste";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("clientForm", new Client());
		model.addAttribute("titre", "Ajouter un client");
		return "clients/add";
	}

	@PostMapping("/add")
	public String addPost(Model model, @Valid @ModelAttribute("clientForm") Client clientForm, BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			message = "";
	//		errors.getFieldErrors().forEach(e->message += e.getField() + "---" + e.getDefaultMessage() + "\n\r");
			//throw new Exception(message);
			model.addAttribute("Errors", errors.getFieldErrors());
			return "clients/add";
		}
		cc.save(clientForm);
		return "redirect:/client/clients";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Integer pid, Model model) throws Exception {
		Optional<Client> c = cc.findById(pid);
		Client cl = cc.findById(pid).get();
		if (c.isEmpty()) {
			throw (new Exception("Client id : " + pid + " non trouvé"));
		}
		model.addAttribute("clientForm", c);
		model.addAttribute("titre", "Modification client : " + cl.getNom() + " " + cl.getPrenom());
		return "clients/update";
	}

	@PostMapping("/update")
	public String updatePost(Model model, @Valid @ModelAttribute("clientForm") Client clientForm, BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			throw (new Exception(errors.getObjectName()));
		}
		cc.save(clientForm);
		return "redirect:/client/clients";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer pid) throws Exception {
		Optional<Client> c = cc.findById(pid);
		if(c.isEmpty()) {
			/**
			 * Exception ClientError package fr.diginamic.tpspringjpa05.exception
			 */
			throw(new Exception("Client id : " + pid + " non trouvé"));
		}
		cc.deleteById(pid);
		return "redirect:/client/clients";
	}
}
