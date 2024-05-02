package projectWork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Prodotto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrelloServiceImpl implements CarrelloService {

	
	@Autowired
	private ProdottoService prodottoService;
    
   @Override
	public void rimuoviProdotto(int id, HttpSession session) {

    	@SuppressWarnings("unchecked")
		List<Prodotto> carrello = (List<Prodotto>)session.getAttribute("carrello");
    	if (carrello != null) {
    		int rimuovi = -1;
    		for (int i = 0; i<carrello.size(); i++) {
    			if (carrello.get(i).getId() == id) {
    				rimuovi = i;
    				break;
    			}
    			if (rimuovi != -1) {
    				carrello.remove (rimuovi);
    			}
    			session.setAttribute("carrello", carrello);
    		}	
    	}	
	}
    
     @Override
	public void svuotaCarrello(HttpSession session) {

    	  session.removeAttribute("carrello");
    	  
	}	
    
    
    @Override
	public void aggiungiProdotto(int id, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Prodotto> carrello = session.getAttribute("carrello") == null ? new ArrayList<>() : (List<Prodotto>) session.getAttribute("carrello");
		carrello.add(prodottoService.getProdottoById(id));
		session.setAttribute("carrello", carrello);
	}
    
    
     

}
