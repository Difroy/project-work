package projectWork.service;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectWork.dao.UtenteDao;

import projectWork.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService {
	@Autowired
	private UtenteDao utenteDao;


	 @Override
	    public boolean controlloUsername(String username) {
	        return utenteDao.findByUsername(username) == null; // Ritorna true se l'username non è già in uso
	    }
	
	

	@Override
	public boolean loginUtente(String username, String password, HttpSession session) {
		Utente utente = utenteDao.findByUsernameAndPassword(username, password);
		if (utente != null)
			session.setAttribute("utente", utente); // setta un attributo nell'ambito della sessione
			return true;

	}

	
	@Override
    public void registraUtente(Utente utente) {
        if (controlloUsername(utente.getUsername())) { // Controlla se l'username è già in uso
            utenteDao.save(utente); // Salva l'utente nel database
        } else {
            throw new IllegalArgumentException("Username già in uso"); // Solleva un'eccezione se l'username è già in uso
        }
    }



	@Override
	public boolean controlloEmail(String email) {
		return utenteDao.findByEmail(email) == null;
	}



	@Override
	public void modificaUtente(Utente utente) {
		utenteDao.save(utente);
		
	}
	 
	/*
	 * @Override public void registraUtente(Utente utente) { try {
	 * utenteDao.save(utente); logger.info("Utente registrato con successo: {}",
	 * utente.getUsername()); } catch (Exception e) {
	 * logger.error("Errore durante il salvataggio dell'utente: {}",
	 * e.getMessage()); } }
	 */
	
	
}