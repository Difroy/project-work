package projectWork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Categoria;
import projectWork.model.Prodotto;
import projectWork.model.Utente;
import projectWork.service.AcquistoService;
import projectWork.service.CarrelloService;
import projectWork.service.CategoriaService;
import org.springframework.http.ResponseEntity; /*Risposta JSON*/
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/carrello")
public class CarrelloController {
	@Autowired
	private CarrelloService carrelloService;
	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private AcquistoService acquistoService;

	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		Utente utente = (Utente) session.getAttribute("utente");
		List<Prodotto> carrello = (List<Prodotto>) session.getAttribute("carrello");
		model.addAttribute("carrello", carrello);
		model.addAttribute("utente", utente);
		double totaleOrdine = calcolaTotale(carrello);
		model.addAttribute("totale", String.format("%.2f", totaleOrdine));
		List<Categoria> categorie = categoriaService.getCategorie();
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

	@GetMapping("/rimuovi")
	public String rimuovi(@RequestParam("id") int id, HttpSession session) {

		carrelloService.rimuoviProdotto(id, session);
		return "redirect:/carrello";
	}

	@GetMapping("/invia")
	public String invia(HttpSession session) {

		Utente utente = (Utente) session.getAttribute("utente");
		@SuppressWarnings("unchecked")
		List<Prodotto> prodottiNelCarrello = (List<Prodotto>) session.getAttribute("carrello");
		acquistoService.inviaAcquisto(utente, prodottiNelCarrello, session);
		carrelloService.svuotaCarrello(session);
		return "redirect:/areariservata";
	}

	@PostMapping("/svuota")
	public String svuotaCarrello(HttpSession session) {
		carrelloService.svuotaCarrello(session);
		return "redirect:/carrello";
	}

	/*
	 * @PostMapping("/svuota")
	 * 
	 * @ResponseBody public ResponseEntity<?> svuotaCarrello(HttpSession session) {
	 * carrelloService.svuotaCarrello(session); return
	 * ResponseEntity.ok().body("{\"status\": \"success\", \"carrelloVuoto\": true}"
	 * ); }
	 */

}