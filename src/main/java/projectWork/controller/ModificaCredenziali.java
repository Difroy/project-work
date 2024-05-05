package projectWork.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import projectWork.model.Utente;
import projectWork.service.UtenteService;

@Controller
@RequestMapping("/modifica-credenziali")
public class ModificaCredenziali {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public String getPage(HttpSession session) {
      
    	
        return "modifica-credenziali";
    }

    @PostMapping
    public String modificaCredenziali(@Valid @ModelAttribute("utente") Utente utente, BindingResult result, HttpSession session) {
        
    	
        return "redirect:/areariservata";
    }

  
}
