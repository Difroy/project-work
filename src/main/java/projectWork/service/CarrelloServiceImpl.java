package projectWork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectWork.model.Prodotto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrelloServiceImpl implements CarrelloService {

    
    private List<Prodotto> prodotti = new ArrayList<>();
    
    @Override
    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    @Override
    public void rimuoviProdotto(Prodotto prodotto) {
        prodotti.remove(prodotto);
    }

    @Override
    public List<Prodotto> getProdotto() {
        return prodotti;
    }

    @Override
    public void svuotaCarrello() {
        prodotti.clear();
    }

    @Override
    public double calcolaTotale() {
        double totale = 0.0;
        for (Prodotto prodotto : prodotti) {
            totale += prodotto.getPrezzo();
        }
        return totale;
    }
}
