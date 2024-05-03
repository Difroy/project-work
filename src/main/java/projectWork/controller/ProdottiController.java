package projectWork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projectWork.model.Prodotto;
import projectWork.service.ProdottoService;

import java.util.List;

@Controller
@RequestMapping("/prodotti")
public class ProdottiController {

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public String getPage(Model model,
                          @RequestParam(name = "categoriaId", required = false) Integer categoriaId,
                          @RequestParam(name = "sottocategoriaId", required=false) Integer sottocategoriaId,
                          @RequestParam(name = "ricerca", required = false) String ricerca ) {
    	
    	List<Prodotto> prodotti;
        if(ricerca != null) {
            prodotti = prodottoService.RicercaProdottto(ricerca);
        }else{
            prodotti = prodottoService.getProdottiByCategoriaAndSottocategoria(categoriaId, sottocategoriaId);
            
        }
model.addAttribute("prodotti", prodotti);
      
        
        

        return "prodottiTest";
    }
    
    @GetMapping("/ricerca")
    public String ricercaProdotto(@RequestParam (name ="ricerca") String ricerca) {
		if (ricerca != null && !ricerca.isEmpty())
    	return "redirect:/prodotti?ricerca="+ricerca;
    	return "redirect:/prodotti";

    }
    
}