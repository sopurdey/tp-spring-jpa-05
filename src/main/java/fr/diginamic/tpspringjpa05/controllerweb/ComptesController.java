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

import fr.diginamic.tpspringjpa05.model.AssuranceVie;
import fr.diginamic.tpspringjpa05.model.Compte;
import fr.diginamic.tpspringjpa05.model.CompteCourant;
import fr.diginamic.tpspringjpa05.model.LivretA;
import fr.diginamic.tpspringjpa05.repository.iCrudAssuranceVie;
import fr.diginamic.tpspringjpa05.repository.iCrudCompte;
import fr.diginamic.tpspringjpa05.repository.iCrudLivretA;

@Controller
@RequestMapping("/compte")
public class ComptesController {
	@Autowired
	iCrudCompte cc;
	@Autowired
	iCrudAssuranceVie ca;
	@Autowired
	iCrudLivretA cl;

	private String message;

	public ComptesController() {

	}

	@GetMapping("/comptes")
	public String findAll(Model model) {
		model.addAttribute("comptes", (List<Compte>) cc.findAll());
		model.addAttribute("titre", "Liste de comptes");
		return "comptes/liste";
	}

	@GetMapping("/comptescourant")
	public String findAllCC(Model model) {
		model.addAttribute("comptes", (List<CompteCourant>) cc.getAllComptesCourant());
		model.addAttribute("titre", "Comptes Courant");
		return "comptes/listecc";
	}

	@GetMapping("/assurancesvie")
	public String findAllAV(Model model) {
		model.addAttribute("comptes", (List<AssuranceVie>) ca.findAll());
		model.addAttribute("titre", "Comptes Assurance Vie");
		return "comptes/listeav";
	}

	@GetMapping("/livretsa")
	public String findAllLA(Model model) {
		model.addAttribute("comptes", (List<LivretA>) cl.findAll());
		model.addAttribute("titre", "Comptes Livret A");
		return "comptes/listela";
	}

	/*****************
	 ****** ADD ******
	 *****************/
	/** Add Compte Courant **/
	@GetMapping("/cc/add")
	public String addCC(Model model) {
		model.addAttribute("compteCCForm", new CompteCourant());
		model.addAttribute("titre", "Ajouter un compte courant");
		return "comptes/adds/addcc";
	}

	@PostMapping("/cc/add")
	public String addPostCC(Model model, @Valid @ModelAttribute("compteCCForm") CompteCourant compteCCForm,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			message = "";
			model.addAttribute("Errors", errors.getFieldErrors());
			return "comptes/adds/addcc";
		}
		cc.save(compteCCForm);
		return "redirect:/compte/comptescourant";
	}

	/** Add Assurance Vie **/
	@GetMapping("/av/add")
	public String addAV(Model model) {
		model.addAttribute("compteAVForm", new AssuranceVie());
		model.addAttribute("titre", "Ajouter une assurance vie");
		return "comptes/adds/addav";
	}

	@PostMapping("/av/add")
	public String addPostAV(Model model, @Valid @ModelAttribute("compteAVForm") AssuranceVie compteAVForm,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			message = "";
			model.addAttribute("Errors", errors.getFieldErrors());
			return "comptes/adds/addav";
		}
		ca.save(compteAVForm);
		return "redirect:/compte/assurancesvie";
	}

	/** Add Livret A **/
	@GetMapping("/la/add")
	public String addLA(Model model) {
		model.addAttribute("compteLAForm", new LivretA());
		model.addAttribute("titre", "Ajouter un livret A");
		return "comptes/adds/addla";
	}

	@PostMapping("/la/add")
	public String addPostLA(Model model, @Valid @ModelAttribute("compteLAForm") LivretA compteLAForm,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			message = "";
			model.addAttribute("Errors", errors.getFieldErrors());
			return "comptes/adds/addla";
		}
		cl.save(compteLAForm);
		return "redirect:/compte/livretsa";
	}

	/*****************
	 **** UPDATE ****
	 *****************/
	/** Update Compte Courant **/
	@GetMapping("/update/cc/{id}")
	public String updateCC(@PathVariable("id") Integer pid, Model model) throws Exception {
		Optional<CompteCourant> c = cc.findCCById(pid);
		Compte ccc = cc.findCCById(pid).get();
		if (c.isEmpty()) {
			throw (new Exception("Compte id : " + pid + " non trouvé"));
		}
		model.addAttribute("compteCCForm", c);
		model.addAttribute("titre", "Modification du compte : " + ccc.getNumero());
		return "comptes/updates/updatecc";
	}

	@PostMapping("/update/cc")
	public String updatePostCC(Model model, @Valid @ModelAttribute("comptCCeForm") CompteCourant compteCCForm,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			throw (new Exception(errors.getObjectName()));
		}
		cc.save(compteCCForm);
		return "redirect:/compte/comptescourant";
	}

	/** Update Assurance Vie **/
	@GetMapping("/update/av/{id}")
	public String updateAV(@PathVariable("id") Integer pid, Model model) throws Exception {
		Optional<AssuranceVie> c = ca.findById(pid);
		Compte cca = ca.findById(pid).get();
		if (c.isEmpty()) {
			throw (new Exception("Compte id : " + pid + " non trouvé"));
		}
		model.addAttribute("compteAVForm", c);
		model.addAttribute("titre", "Modification du compte : " + cca.getNumero());
		return "comptes/updates/updateav";
	}

	@PostMapping("/update/av")
	public String updatePostAV(Model model, @Valid @ModelAttribute("compteAVForm") AssuranceVie compteAVForm,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			throw (new Exception(errors.getObjectName()));
		}
		ca.save(compteAVForm);
		return "redirect:/compte/assurancesvie";
	}

	/** Update Livret A **/
	@GetMapping("/update/la/{id}")
	public String updateLA(@PathVariable("id") Integer pid, Model model) throws Exception {
		Optional<LivretA> c = cl.findById(pid);
		Compte ccl = cl.findById(pid).get();
		if (c.isEmpty()) {
			throw (new Exception("Compte id : " + pid + " non trouvé"));
		}
		model.addAttribute("compteLAForm", c);
		model.addAttribute("titre", "Modification du compte : " + ccl.getNumero());
		return "comptes/updates/updatela";
	}

	@PostMapping("/update/la")
	public String updatePostLA(Model model, @Valid @ModelAttribute("compteLAForm") LivretA compteLAForm,
			BindingResult errors) throws Exception {
		if (errors.hasErrors()) {
			throw (new Exception(errors.getObjectName()));
		}
		cl.save(compteLAForm);
		return "redirect:/compte/livretsa";
	}

	/*****************
	 **** DELETE ****
	 *****************/
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer pid) throws Exception {
		Optional<Compte> c = cc.findById(pid);
		if (c.isEmpty()) {
			/**
			 * Exception CompteError package fr.diginamic.tpspringjpa05.exception
			 */
			throw (new Exception("Compte id : " + pid + " non trouvé"));
		}
		cc.deleteById(pid);
		switch (c.get().getType()) {
		case "Assurance Vie":
			return "redirect:/compte/assurancesvie";
		case "Compte Courant":
			return "redirect:/compte/comptescourant";
		case "Livret A":
			return "redirect:/compte/livretsa";
		default:
			return "redirect:/compte/comptes";
		}
		/*
		if (c.get().getType() == "Compte Courant") {
			return "redirect:/compte/comptescourant";
		} else if (c.get().getType() == "Assurance Vie") {
			return "redirect:/compte/assurancesvie";
		} else if (c.get().getType() == "Livret A") {
			return "redirect:/compte/livretsa";
		}
		return "redirect:/compte/comptes";
		*/
	}
	
	/*
	@GetMapping("/delete/cc/{id}")
	public String deleteCC(@PathVariable("id") Integer pid) throws Exception {
		Optional<CompteCourant> c = cc.findCCById(pid);
		if (c.isEmpty()) {

			throw (new Exception("Compte id : " + pid + " non trouvé"));
		}
		cc.deleteById(pid);
		return "redirect:/compte/comptescourant";
	}
	
	
	@GetMapping("/delete/av/{id}")
	public String deleteAV(@PathVariable("id") Integer pid) throws Exception {
		Optional<AssuranceVie> c = ca.findById(pid);
		if (c.isEmpty()) {

			throw (new Exception("Compte id : " + pid + " non trouvé"));
		}
		cc.deleteById(pid);
		return "redirect:/compte/comptescourant";
	}
	*/
}
