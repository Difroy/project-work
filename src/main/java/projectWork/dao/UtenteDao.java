package projectWork.dao;

import org.springframework.data.repository.CrudRepository;


import projectWork.model.Utente;

public interface UtenteDao extends CrudRepository<Utente, Integer> {
    Utente findByUsernameAndPassword(String username, String password); // serve per recuperare le credenziali dell'utente, quindi per il login
    Utente findByUsername(String username); // verifica l'unicità dell'username
}