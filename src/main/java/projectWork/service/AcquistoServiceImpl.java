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

	@Override
	public void inviaAcquisto(Utente utente, List<Prodotto> prodottiNelCarrello, HttpSession session) {

		Acquisto acquisto = new Acquisto();
		acquisto.setDataAcquisto(LocalDate.now());
		acquisto.setCostoSpedizione(0);
		acquisto.setImportoTotale(prodottoService.getTotaleCarrello(session));
		acquisto.setMetodoDiPagamento("paypal");
		acquisto.setStatoPagamento("in corso");
		acquisto.setUtente(utente);
		acquisto.setProdotti(prodottiNelCarrello);
		acquistoDao.save(acquisto);
	}
}
