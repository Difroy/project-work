package projectWork.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import projectWork.model.Utente;
import projectWork.service.UtenteService;

@Controller
@RequestMapping("/modificacredenziali")
public class ModificaCredenzialiController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public String getPage(HttpSession session, Model model) {
    	Utente utente = (Utente) session.getAttribute("utente");
    	model.addAttribute("utente", utente);
      
    	
        return "modificaCred";
    }

    
    
    @PostMapping
	public String formManager (
			@Valid @ModelAttribute("utente") Utente utente,
			BindingResult result,
			HttpSession session
	) {
		if(result.hasErrors())
			return "modificaCred";
		utenteService.registraUtente(utente);
		session.setAttribute("utente", utente);
		return "redirect:/areariservata";
	}
  
}