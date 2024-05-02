package projectWork.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projectWork.model.Categoria;
import projectWork.model.Prodotto;
import projectWork.model.Sottocategoria;
import projectWork.service.CategoriaService;

@Controller
@RequestMapping("/categoria")

public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String getPage(@RequestParam("id") int id, Model model) {
		List<Categoria>categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		Categoria categoria = categoriaService.getCategoriaById(id);
		List<Prodotto>prodotti = new ArrayList<>();
		for (Sottocategoria sottocategoria: categoria.getSottocategorie())
			for (Prodotto prodotto : sottocategoria.getProdotti())
				prodotti.add(prodotto);
		model.addAttribute("prodotti", prodotti);
		model.addAttribute("categoria", categoria);
		
		return "categoria";
		
	}
	
}
