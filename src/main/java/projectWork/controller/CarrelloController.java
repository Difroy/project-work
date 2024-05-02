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

@Controller
@RequestMapping("/carrello")
public class CarrelloController {

	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		boolean online = session.getAttribute("Utente") != null;
		model.addAttribute("online", online);
		System.out.println(model.getAttribute("online"));
		List<Prodotto> carrello = (List<Prodotto>) session.getAttribute("carrello");
		model.addAttribute("prodottiCarrello", carrello);

		double totaleOrdine = calcolaTotale(carrello);

		return null;

	}

	private double calcolaTotale(List<Prodotto> carrello) {
		double totale = 0;
		if (carrello != null) {
			for (Prodotto prodotto : carrello) {
				totale += prodotto.getPrezzo();
			}
		}
		return totale;
	}
	@GetMapping ("/rimuovi")
	public String rimuovi (@RequestParam("id") int id, HttpSession session) {
		
		return null;
		
		
	}
	
	
	
}
