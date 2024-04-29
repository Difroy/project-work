package projectWork.service;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Prodotto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProdottoService {
   
	List<Prodotto> getProdotti();
    
    
    Prodotto getProdottoById(int id);
    
    
    boolean aggiungiAlCarrello(int idProdotto, HttpSession session);
    
    
    List<Prodotto> getCarrello(HttpSession session);
    
    
    void rimuoviDalCarrello(int idProdotto, HttpSession session);
    
    
    double getTotaleCarrello(HttpSession session);


    void registraProdotto(Prodotto prodotto, int idSottocategoria, String nome, String descrizione, String prezzo, MultipartFile immagine, String altro);
    
    
    void cancellaProdotto(int id);
}
