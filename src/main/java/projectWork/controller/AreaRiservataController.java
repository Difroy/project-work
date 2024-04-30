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
import projectWork.model.Utente;
import projectWork.service.AcquistoService;
import projectWork.service.CategoriaService;
import projectWork.service.ProdottoService;
import projectWork.service.UtenteService;

@Controller
@RequestMapping("/areariservata")
public class AreaRiservataController {

	@Autowired
	private ProdottoService prodottoService;

	@Autowired
	UtenteService profiloService;
	
	@Autowired
	AcquistoService acquistoService;
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public String getPage(Model model, HttpSession session,
			@RequestParam(name = "send", required = false) String send) {

		if (session.getAttribute("utente") == null)
			return "redirect:/loginutente";
		Utente utente = (Utente) session.getAttribute("utente");
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
	@GetMapping("/invia")
	public String invia (HttpSession session) {
		acquistoService.inviaAcquisto(session);
		return "redirect:/areariservata?send";	
	}
	
	
}
