package projectWork.service;

import projectWork.model.Prodotto;

import java.util.List;

public interface CarrelloService {

    void aggiungiProdotto(Prodotto prodotto);

    void rimuoviProdotto(Prodotto prodotto);

    List<Prodotto> getProdotto();

    void svuotaCarrello();

    double calcolaTotale();

}
