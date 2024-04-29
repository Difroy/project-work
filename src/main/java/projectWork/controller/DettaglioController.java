/*package projectWork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import projectWork.Model.Prodotto;
import projectWork.Service.ProdottoService;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {

	@Autowired
	private ProdottoService prodottoService;

	@GetMapping
	public String getPage(@RequestParam("id") int id, Model model,
			@RequestParam(name = "add", required = false) String add) {
		Prodotto prodotto = prodottoService.getProdottoById(id);
		model.addAttribute("prodotto", prodotto);
		model.addAttribute("add", add);
		return "dettaglio";
	}

	@GetMapping("/aggiungi")
	public String aggiungi(@RequestParam("id") int id, HttpSession session) {

		if (!prodottoService.aggiungiAlCarrello(id, session))
			return "redirect:/dettaglio?id=" + id + "&add=n";
		return "redirect:/dettaglio?id=" + id + "&add=y";
	}
}*/





