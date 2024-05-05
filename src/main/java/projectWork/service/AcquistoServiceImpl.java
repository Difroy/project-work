package projectWork.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectWork.dao.AcquistoDao;
import projectWork.model.Acquisto;
import projectWork.model.Prodotto;
import projectWork.model.Utente;

import java.time.LocalDate;
import java.util.List;

@Service
public class AcquistoServiceImpl implements AcquistoService {
	@Autowired
	private AcquistoDao acquistoDao;

	@Autowired
	private ProdottoService prodottoService;

	@Override
	public List<Acquisto> getAcquisti() {
		return (List<Acquisto>) acquistoDao.findAll();
	}

	@Override
	public Acquisto getAcquistoById(int id) {
		return acquistoDao.findById(id).get();
	}

	/*
	 * @Override public void inviaAcquisto(Utente utente, List<Prodotto>
	 * prodottiNelCarrello, HttpSession session) {
	 * 
	 * Acquisto acquisto = new Acquisto();
	 * acquisto.setDataAcquisto(LocalDate.now()); acquisto.setCostoSpedizione(0);
	 * acquisto.setImportoTotale(prodottoService.getTotaleCarrello(session));
	 * acquisto.setMetodoDiPagamento("paypal");
	 * acquisto.setStatoPagamento("in corso"); acquisto.setUtente(utente);
	 * acquisto.setProdotti(prodottiNelCarrello); acquistoDao.save(acquisto); }
	 */
	/*
	 * @Override public void inviaAcquisto(Utente utente, List<Prodotto>
	 * prodottiNelCarrello, HttpSession session) { double totale =
	 * prodottiNelCarrello.stream().mapToDouble(Prodotto::getPrezzo).sum(); //
	 * Calcola il totale qui
	 * 
	 * Acquisto acquisto = new Acquisto();
	 * acquisto.setDataAcquisto(LocalDate.now()); acquisto.setCostoSpedizione(0); //
	 * O imposta un valore reale se necessario acquisto.setImportoTotale(totale);
	 * acquisto.setMetodoDiPagamento("PayPal"); // Assicurati che questo valore
	 * venga passato correttamente acquisto.setStatoPagamento("in corso");
	 * acquisto.setUtente(utente); acquisto.setProdotti(prodottiNelCarrello);
	 * acquisto.setIndirizzoSpedizione(utente.getIndirizzoSpedizione()); //
	 * Assicurati che questo valore sia disponibile
	 * 
	 * acquistoDao.save(acquisto); }
	 */
	
	@Override
	public void inviaAcquisto(Utente utente, List<Prodotto> prodottiNelCarrello, String indirizzoSpedizione, String metodoPagamento, HttpSession session) {
	    Acquisto acquisto = new Acquisto();
	    acquisto.setUtente(utente);
	    acquisto.setProdotti(prodottiNelCarrello);
	    acquisto.setIndirizzoSpedizione(indirizzoSpedizione);
	    acquisto.setDataAcquisto(LocalDate.now());
	    acquisto.setCostoSpedizione(0); // Imposta un costo di spedizione, se necessario
	    acquisto.setImportoTotale(prodottoService.getTotaleCarrello(session)); // Utilizza il metodo getTotaleCarrello qui
	    acquisto.setMetodoDiPagamento(metodoPagamento);
	    acquisto.setStatoPagamento("In corso");

	    acquistoDao.save(acquisto);
	}

	
	
	
	
}
