package projectWork.controller;

import java.util.ArrayList;
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
import projectWork.model.Sottocategoria;
import projectWork.model.Utente;
import projectWork.service.CarrelloService;
import projectWork.service.CategoriaService;
import projectWork.service.ProdottoService;

@Controller
@RequestMapping("/categoria")

public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private CarrelloService carrelloService;
	@Autowired
	private ProdottoService prodottoService;
	
	@GetMapping
	public String getPage(HttpSession session, @RequestParam(name="id",required =false ) Integer id, Model model, @RequestParam(name="filtro", required=false) String filtro, @RequestParam (name="add", required=false) String add,
			@RequestParam (name = "ricerca", required = false) String ricerca ) {
		
		Utente utente = (Utente) session.getAttribute("utente");
	    model.addAttribute("utente", utente);
		List<Categoria>categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		model.addAttribute("ricerca", ricerca);
		model.addAttribute("add", add);
		Categoria categoria = new Categoria();
		if (id != null)
		categoria = categoriaService.getCategoriaById(id);
		List<Prodotto>prodotti = new ArrayList<>();
		for (Sottocategoria sottocategoria: categoria.getSottocategorie())
			for (Prodotto prodotto : sottocategoria.getProdotti())
				prodotti.add(prodotto);
		if (filtro != null) {
			prodotti= prodotti.stream()
					.filter(p-> p.getSottocategoria().getNome().equals(filtro)).toList();
			
		}
		 if(ricerca != null) 
	            prodotti =   prodottoService.RicercaProdottto(ricerca);
	
		 
		model.addAttribute("prodotti", prodotti);
		model.addAttribute("categoria", categoria);
		return "categoria";
	}
		
		
	@GetMapping ("/aggiungi")
	public String aggiungi (@RequestParam("id") int id, HttpSession session, @RequestParam("idCat") int idCat) {
		carrelloService.aggiungiProdotto(id, session);
		Prodotto prodotto = prodottoService.getProdottoById(id);
		
		return "redirect:/categoria?id="+prodotto.getSottocategoria().getCategoria().getId()+"&add";
		
	}
	
	 @GetMapping("/ricerca")
	    public String ricercaProdotto(@RequestParam (name ="ricerca") String ricerca) {
			if (ricerca != null && !ricerca.isEmpty())
	    	return "redirect:/categoria?ricerca="+ricerca;
	    	return "redirect:/categoria";
	    }
	
}
