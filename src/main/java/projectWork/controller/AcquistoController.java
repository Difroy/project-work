package projectWork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Prodotto;
import projectWork.model.Utente;
import projectWork.service.AcquistoService;
import projectWork.service.CarrelloService;
import projectWork.service.ProdottoService;
import projectWork.service.UtenteService;

@Controller
@RequestMapping ("/acquisto")
public class AcquistoController {

	@Autowired
	private AcquistoService acquistoService;
	@Autowired
	private CarrelloService carrelloService;
	@Autowired
	private ProdottoService prodottoService;
	@Autowired
	private UtenteService utenteService;
	

		@GetMapping
		public String getPage(HttpSession session, Model model,
			@RequestParam(name= "send", required = false) String send)
		{
			if(session.getAttribute("utente") == null)
				return "redirect:/login";
			Utente utente = (Utente) session.getAttribute("utente");
			model.addAttribute("utente", utente);
			model.addAttribute("carrello", prodottoService.getCarrello(session));
			model.addAttribute("totale", prodottoService.getTotaleCarrello(session));
			model.addAttribute("send", send);
			return "areariservata";
		}
	}
	

	/*@GetMapping("/invia")
	public String invia (HttpSession session) {
		
		Utente utente = (Utente) session.getAttribute("utente");
		@SuppressWarnings("unchecked")
		List<Prodotto> prodottiNelCarrello = (List<Prodotto>) session.getAttribute("carrello");
		carrelloService.svuotaCarrello(session);
		acquistoService.inviaAcquisto(utente, prodottiNelCarrello);
		return "redirect:/areariservata";	
	}

	
}*/