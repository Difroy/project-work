package projectWork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Categoria;
import projectWork.service.CategoriaService;

//localhost:8080
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public String getPage(Model model, HttpSession session) {

		List<Categoria> categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);

		return "indexTest";

	}
}
