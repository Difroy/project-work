package projectWork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import projectWork.model.Profilo;
import projectWork.model.Utente;
import projectWork.service.UtenteService;

//localhost:8080/registrazioneutente

@Controller
@RequestMapping("/registrazioneutente")
public class RegistrazioneUtenteController {

	@Autowired
	public UtenteService utenteService;
	
	@GetMapping
	public String getPage (Model model) {
		Utente utente = new Utente ();
		model.addAttribute("utente", utente);
		return "registrazioneUtenteTest";
		
	}
	
	@PostMapping
	public String formManager (@Valid @ModelAttribute ("utente") Utente utente, BindingResult result, Model model) {
		if (result.hasErrors())
			return "registrazioneutente";
		if (!utenteService.controlloUsername(utente.getUsername())) {
		model.addAttribute("error", "Username non disponibile");
		return "registrazioneutente";	
			
		}
		utenteService.registraUtente(utente);
		return "redirect:/loginutente";
	}
	
	
	
}

