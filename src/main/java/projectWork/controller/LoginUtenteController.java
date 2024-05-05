package projectWork.controller;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Categoria;
import projectWork.service.CategoriaService;
import projectWork.service.UtenteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class LoginUtenteController
{
    @Autowired
    private UtenteService utenteService;
    @Autowired
	private CategoriaService categoriaService;
    @GetMapping
    public String getPage(HttpSession session, @RequestParam(name = "error", required = false) String error, Model model)
    {
    	List<Categoria> categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
        if(session.getAttribute("utente") != null)
            return "redirect:/areariservata";
        model.addAttribute("error", error);
        return "login";
    }
    @PostMapping
    public String formManager(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session
    )
    {
        if(!utenteService.loginUtente(username, password, session))
            return "redirect:/login";
        return "redirect:/areariservata";
    }
}