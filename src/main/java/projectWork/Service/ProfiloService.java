package projectWork.Service;

import jakarta.servlet.http.HttpSession;
import projectWork.Model.Profilo;

public interface ProfiloService {
    boolean loginProfilo(String username, String password, HttpSession session);
    void registraProfilo(Profilo profilo);
    boolean controlloUsername(String username);
}
