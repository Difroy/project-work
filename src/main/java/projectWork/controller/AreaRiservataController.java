package projectWork.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Categoria;
import projectWork.model.Prodotto;
import projectWork.model.Utente;
import projectWork.service.AcquistoService;
import projectWork.service.CarrelloService;
import projectWork.service.CategoriaService;
import projectWork.service.ProdottoService;
import projectWork.service.UtenteService;

@Controller
@RequestMapping("/areariservata")
public class AreaRiservataController {

	@Autowired
	private ProdottoService prodottoService;

	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private AcquistoService acquistoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired CarrelloService carrelloService;

	@GetMapping
	public String getPage(Model model, HttpSession session,
			@RequestParam(name = "send", required = false) String send) {

		if (session.getAttribute("utente") == null)
			return "redirect:/loginutente";
		Utente utente = (Utente) session.getAttribute("utente");
		model.addAttribute("acquisti", acquistoService.getAcquisti());
		model.addAttribute("utente", utente);
		model.addAttribute("carrello", prodottoService.getCarrello(session));
		model.addAttribute("totale", prodottoService.getTotaleCarrello(session));
		model.addAttribute("send", send);
		List<Categoria> categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		return "areariservata";
	}
	@GetMapping("/logout")
	public String logoutUtente (HttpSession session) {
		session.removeAttribute("utente");
		return "redirect:/";
		
	}
	
	@GetMapping("/rimuovi")
	public String rimuoviProdotto(@RequestParam("id")int idProdotto, HttpSession session ) {
		prodottoService.rimuoviDalCarrello(idProdotto, session);
		
		return "redirect:/areariservata";
		
	}
	
	@PostMapping
	public String formManager (
			@Valid @ModelAttribute("utente") Utente utente,
			BindingResult result,
			HttpSession session
	) {
		if(result.hasErrors())
			return "areariservata";
		utenteService.registraUtente(utente);
		session.setAttribute("utente", utente);
		return "redirect:/areariservata";
	}
	
	

	
	
}
