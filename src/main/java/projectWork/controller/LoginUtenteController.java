package projectWork.controller;

import jakarta.servlet.http.HttpSession;
import projectWork.service.UtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loginutente")
public class LoginUtenteController
{
    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public String getPage(HttpSession session, @RequestParam(name = "error", required = false) String error, Model model)
    {
        if(session.getAttribute("utente") != null)
            return "redirect:/riservatautente";
        model.addAttribute("error", error);
        return "loginUtente";
    }

    @PostMapping
    public String formManager(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session
    )
    {

        if(!utenteService.loginUtente(username, password, session))
            return "redirect:/loginutente?error";
        return "redirect:/riservatautente";
    }

}