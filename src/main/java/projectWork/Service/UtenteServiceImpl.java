package projectWork.Service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectWork.Dao.UtenteDao;
import projectWork.Model.Profilo;
import projectWork.Model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService {
    @Autowired
    private UtenteDao utenteDao;

    @Override
    public boolean loginUtente(String username, String password, HttpSession session) {
        Utente utente = utenteDao.findByUtenteUsernameAndUtentePassword(username, password);
        if(utente != null){
            session.setAttribute("utente",utente); //setta un attributo nell'ambito della sessione
            return true;
        }
        return false;
    }

    @Override
    public void registraUtente(Utente utente) {
        utenteDao.save(utente);
    }

    @Override
    public boolean controlloUsername(String username) {
        if(utenteDao.findByUtenteUsername(username) == null) // se l'username non è già in uso
            return true;
        return false;
    }
}
