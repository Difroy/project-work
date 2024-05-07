package projectWork.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import projectWork.model.Categoria;
import projectWork.model.Utente;
import projectWork.service.CategoriaService;
import projectWork.service.UtenteService;

@Controller
@RequestMapping("/registrazioneutente")
public class RegistrazioneUtenteController {

	@Autowired
	public UtenteService utenteService;
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping
	public String getPage (Model model) {
		List<Categoria> categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		Utente utente = new Utente ();
		model.addAttribute("utente", utente);
		return "registrazioneutente";
	}
	
    @PostMapping
    public String processaFormRegistrazione(@Valid @ModelAttribute("utente") Utente utente,
                                             BindingResult result, Model model) {
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

        if (!utenteService.controlloUsername(utente.getUsername())) {
            model.addAttribute("erroreUsername", true);
            return "registrazioneutente";
        }
        
        
        if(!utenteService.controlloEmail(utente.getEmail())) {
        	model.addAttribute("erroreEmail", true);
        	return "registrazioneutente";
        }
        
        if(!utenteService.controlloPassword(utente.getPassword())) {
        	model.addAttribute("errorePassword", true);
        	return "registrazioneutente";
        }

 
        // Altre operazioni di registrazione
        utenteService.registraUtente(utente);

        return "redirect:/login";
    }
}