package projectWork.Service;

import jakarta.servlet.http.HttpSession;
import projectWork.Model.Profilo;
import projectWork.Model.Utente;

public interface UtenteService {
    boolean loginUtente(String username, String password, HttpSession session);
    void registraUtente(Utente utente);
    boolean controlloUsername(String username);
}
