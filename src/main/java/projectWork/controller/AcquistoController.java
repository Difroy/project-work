package projectWork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import projectWork.model.Utente;
import projectWork.service.ProdottoService;
@Controller
@RequestMapping ("/acquisto")
public class AcquistoController {

	@Autowired
	private ProdottoService prodottoService;
	
	

		@GetMapping
		public String getPage(HttpSession session, Model model,
			@RequestParam(name= "send", required = false) String send, @RequestParam(name = "ricerca", required = false) String ricerca)
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