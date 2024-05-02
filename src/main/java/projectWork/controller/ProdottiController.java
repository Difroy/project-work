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
                          @RequestParam(name = "categoriaId") Integer categoriaId,
                          @RequestParam(name = "sottocategoriaId") Integer sottocategoriaId) {

        List<Prodotto> prodotti = prodottoService.getProdottiByCategoriaAndSottocategoria(categoriaId, sottocategoriaId);
        model.addAttribute("prodotti", prodotti);

        return "prodottiTest";
    }
}