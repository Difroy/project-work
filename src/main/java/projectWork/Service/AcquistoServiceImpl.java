package projectWork.Service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import projectWork.Dao.AcquistoDao;
import projectWork.Model.Acquisto;
import projectWork.Model.Prodotto;
import projectWork.Model.Profilo;

import java.time.LocalDate;
import java.util.List;

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
    public void inviaAcquisto(HttpSession session) {
        List<Prodotto> ordine = prodottoService.getCarrello(session);
        Profilo profilo = (Profilo) session.getAttribute("profilo");

        if(ordine != null && profilo != null) {
            Acquisto acquisto = new Acquisto();
            acquisto.setDataAcquisto(LocalDate.now());
            acquisto.setCostoSpedizione(0);
            acquisto.setImportoTotale(prodottoService.getTotaleCarrello(session));
            acquisto.setMetodoDiPagamento(null);
            acquisto.setIndirizzoDomicilio(null);
            acquisto.setStatoPagamento(null);
            acquistoDao.save(acquisto);
        }
    }
}
