package projectWork.service;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Acquisto;
import projectWork.model.Prodotto;
import projectWork.model.Utente;

import java.util.List;

public interface AcquistoService {
    public List<Acquisto> getAcquisti();
     
    
    void inviaAcquisto(Utente utente, List <Prodotto> prodottiNelCarrello, HttpSession session);
    
     
    Acquisto getAcquistoById(int id);
    
   
}
