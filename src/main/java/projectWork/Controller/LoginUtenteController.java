package projectWork.Controller;

import jakarta.servlet.http.HttpSession;
import projectWork.Service.ProfiloService;

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
    private ProfiloService profiloService;
    
    @GetMapping
   public String getPage(HttpSession session, @RequestParam(name = "error", required = false) String error, Model model)
    {
    	if(session.getAttribute("profilo") != null)
    		return "redirect:/riservatautente";
    	model.addAttribute("error", error);
        return "loginutente";
    }

    @PostMapping
    public String formManager(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session
    )
    {
    	
    	if(!profiloService.loginProfilo(username, password, session))
    		return "redirect:/loginutente?error";
        return "redirect:/riservatautente";
    }
    	
}
