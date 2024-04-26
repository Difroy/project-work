package projectWork.Service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectWork.Dao.ProfiloDao;
import projectWork.Model.Profilo;

@Service
public class ProfiloServiceImpl implements ProfiloService {
    @Autowired
    private ProfiloDao profiloDao;

    @Override
    public boolean loginProfilo(String username, String password, HttpSession session) {
        Profilo profilo = profiloDao.findByUtenteUsernameAndUtentePassword(username, password);
        if(profilo != null){
            session.setAttribute("profilo",profilo); //setta un attributo nell'ambito della sessione
            return true;
        }
        return false;
    }

    @Override
    public void registraProfilo(Profilo profilo) {
        profiloDao.save(profilo);
    }

    @Override
    public boolean controlloUsername(String username) {
        if(profiloDao.findByUtenteUsername(username) == null) // se l'username non è già in uso
            return true;
        return false;
    }
}
