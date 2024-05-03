package projectWork.controller;

import java.time.LocalDate;
import java.time.Period;

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
		return "registrazioneUtente";
		
	}
	
	
	@PostMapping
	public String formManager(
	        @Valid @ModelAttribute("utente") Utente utente,
	        BindingResult result,
	        HttpSession session
	) {
	    if (result.hasErrors())
	        return "registrazioneutente";
	    utenteService.registraUtente(utente);
	    session.setAttribute("utente", utente); // Aggiungi l'utente alla sessione
	    return "redirect:/areariservata"; // Reindirizza alla pagina dell'area riservata
	}
	
	//prova maggiorenne
	@GetMapping("/registrazioneutente")
    public String mostraFormRegistrazione(Model model) {
		Utente utente = new Utente ();
        model.addAttribute("utente", utente);
        return "registrazioneutente";
    }

    @PostMapping("/registrazioneutente")
    public String processaFormRegistrazione(@ModelAttribute("utente") Utente utente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registrazioneutente";
        }

        LocalDate dataDiNascita = utente.getProfilo().getDataDiNascita();
        if (dataDiNascita != null) {
            LocalDate oggi = LocalDate.now();
            Period period = Period.between(dataDiNascita, oggi);
            if (period.getYears() < 18) {
                model.addAttribute("erroreMaggiorenne", true);
                return "registrazioneutente";
            }
        }

        // Altre operazioni di registrazione

        return "redirect:/login"; 
    }
}

