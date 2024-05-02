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
import projectWork.service.CarrelloService;
import projectWork.service.CategoriaService;

@Controller
@RequestMapping("/categoria")

public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private CarrelloService carrelloService;
	
	@GetMapping
	public String getPage(@RequestParam("id") int id, Model model, @RequestParam(name="filtro", required=false) String filtro, @RequestParam (name="add", required=false) String add) {
		
		List<Categoria>categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		model.addAttribute("add", add);
		Categoria categoria = categoriaService.getCategoriaById(id);
		List<Prodotto>prodotti = new ArrayList<>();
		for (Sottocategoria sottocategoria: categoria.getSottocategorie())
			for (Prodotto prodotto : sottocategoria.getProdotti())
				prodotti.add(prodotto);
		if (filtro != null) {
			prodotti= prodotti.stream()
					.filter(p-> p.getSottocategoria().getNome().equals(filtro)).toList();
			
		}
		
		
		
		model.addAttribute("prodotti", prodotti);
		model.addAttribute("categoria", categoria);
		
		return "categoria";
		
	}
	
	@GetMapping ("/aggiungi")
	
	public String aggiungi (@RequestParam("id") int id, HttpSession session, @RequestParam("idCat") int idCat) {
		carrelloService.aggiungiProdotto(id, session);
		return "redirect:/categoria?id="+idCat+"&add";
		
	}
	
}
