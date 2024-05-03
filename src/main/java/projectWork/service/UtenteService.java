package projectWork.service;

import jakarta.servlet.http.HttpSession;
import projectWork.model.Utente;

public interface UtenteService {
    boolean loginUtente(String username, String password, HttpSession session);
    void registraUtente(Utente utente);
    boolean controlloUsername(String username);
    
}
