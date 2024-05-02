package projectWork.service;



import jakarta.servlet.http.HttpSession;

public interface CarrelloService {

    void aggiungiProdotto(int id, HttpSession session);

    void rimuoviProdotto(int id, HttpSession session);

    void svuotaCarrello(HttpSession session);

   

}
