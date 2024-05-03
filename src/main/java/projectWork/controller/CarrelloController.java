package projectWork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Categoria;
import projectWork.model.Prodotto;
import projectWork.model.Utente;
import projectWork.service.CarrelloService;
import projectWork.service.CategoriaService;

@Controller
@RequestMapping("/carrello")
public class CarrelloController {
	@Autowired
	private CarrelloService carrelloService;
@Autowired
private CategoriaService categoriaService;
	
	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		Utente utente = (Utente) session.getAttribute("utente");
		List<Prodotto> carrello = (List<Prodotto>) session.getAttribute("carrello");
		model.addAttribute("carrello", carrello);
		model.addAttribute("utente", utente);
		double totaleOrdine = calcolaTotale(carrello);
		model.addAttribute("totale", String.format("%.2f", totaleOrdine));
		List<Categoria>categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		return "carrello";
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
		
		carrelloService.rimuoviProdotto(id, session);
		return "redirect:/carrello";
	}
	
	
	@GetMapping("/aggiungi")
	public String aggiungi(
			@RequestParam("id") int id, HttpSession session) {
		carrelloService.aggiungiProdotto(id, session);
		return "redirect:/carrello";
	}
	
	
	
}