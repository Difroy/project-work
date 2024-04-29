package projectWork.Dao;

import org.springframework.data.repository.CrudRepository;

import projectWork.Model.Profilo;
import projectWork.Model.Utente;

public interface UtenteDao extends CrudRepository<Utente, Integer>{
    Utente findByUtenteUsernameAndUtentePassword(String username, String password); // serve per recuperare le credenziali dell'utente, quindi per il login
    Utente findByUtenteUsername(String username); // verifica l'unicità dell'username
}
