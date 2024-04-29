package projectWork.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import projectWork.Model.Utente;
import projectWork.Service.ProdottoService;
import projectWork.Service.ProfiloService;

@Controller
@RequestMapping("/areariservata")
public class AreaRiservataController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	@Autowired ProfiloService profiloService;
	
	@GetMapping
	public String getPage(Model model, HttpSession session, @RequestParam (name="send", required=false) String send) {
		
		if(session.getAttribute("utente")==null)
			return "redirect:/loginutente";
		Utente utente = (Utente) session.getAttribute("utente");
		model.addAttribute("utente", utente);
		
		
		return send;
		
		
		
		
	}
}

