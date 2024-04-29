package projectWork.Dao;

import org.springframework.data.repository.CrudRepository;
import projectWork.Model.Profilo;

public interface ProfiloDao extends CrudRepository<Profilo, Integer> {
    Profilo findByUtenteUsernameAndUtentePassword(String username, String password); // serve per recuperare le credenziali dell'utente, quindi per il login
    Profilo findByUtenteUsername(String username); // verifica l'unicità dell'username
}