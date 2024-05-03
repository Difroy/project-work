package projectWork.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import projectWork.dao.ProdottoDao;
import projectWork.model.Prodotto;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdottoServiceImpl implements ProdottoService {
	@Autowired
	private ProdottoDao prodottoDao;

	@Autowired
	private SottocategoriaService sottocategoriaService;

	@Override
	public List<Prodotto> getProdotti() {
		return (List<Prodotto>) prodottoDao.findAll();
	}

	@Override
	public Prodotto getProdottoById(int id) {
		Optional<Prodotto> optionalProdotto = prodottoDao.findById(id);
		if (optionalProdotto.isPresent())
			return optionalProdotto.get();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean aggiungiAlCarrello(int idProdotto, HttpSession session) {
		Prodotto prodotto = getProdottoById(idProdotto);
		List<Prodotto> ordine;

		if (session.getAttribute("ordine") != null) {
			ordine = (List<Prodotto>) session.getAttribute("carrello");
			for (Prodotto p : ordine)
				if (p.getId() == prodotto.getId())
					return false;

			ordine.add(prodotto);
			session.setAttribute("ordine", ordine);
			return true;

		} else {
			ordine = new ArrayList<>();
			ordine.add(prodotto);
			session.setAttribute("ordine", ordine);
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prodotto> getCarrello(HttpSession session) {
		if (session.getAttribute("ordine") != null) {
			return (List<Prodotto>) session.getAttribute("ordine");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void rimuoviDalCarrello(int idProdotto, HttpSession session) {
		List<Prodotto> ordine = (List<Prodotto>) session.getAttribute("ordine");

		for (Prodotto p : ordine)
			if (p.getId() == idProdotto) {
				ordine.remove(p);
				break;
			}

		ordine = ordine.stream().filter(p -> p.getId() != idProdotto).collect(Collectors.toList());

		if (ordine.size() > 0)
			session.setAttribute("ordine", ordine);
		else
			session.removeAttribute("ordine");
	}

	@SuppressWarnings("unchecked")
	@Override
	public double getTotaleCarrello(HttpSession session) {
		List<Prodotto> carrello = (List<Prodotto>) session.getAttribute("carrello");

		if (carrello != null) {
			double totale = carrello.stream().mapToDouble(Prodotto::getPrezzo).reduce(0, Double::sum);

			return totale;
		}

		return 0;
	}

	@Override
	public void registraProdotto(Prodotto prodotto, int idSottocategoria, String nome, String descrizione,
			String prezzo, MultipartFile immagine, String altro) {
		prodotto.setSottocategoria(sottocategoriaService.getSottocategoriaById(idSottocategoria));
		prodotto.setNome(nome);
		prodotto.setDescrizione(descrizione);
		prodotto.setPrezzo(Double.parseDouble(prezzo));
		if (immagine != null && !immagine.isEmpty()) {
			try {
				String formato = immagine.getContentType();
				String immagineCodificata = "data:" + formato + ";base64,"
						+ Base64.getEncoder().encodeToString(immagine.getBytes());
				prodotto.setImmagine(immagineCodificata);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			prodottoDao.save(prodotto);
		}
	}

	@Override
	public void cancellaProdotto(int id) {
		prodottoDao.deleteById(id);
	}

	@Override
	public List<Prodotto> getProdottiByCategoriaAndSottocategoria(Integer categoriaId, Integer sottocategoriaId) {
		return prodottoDao.findBySottocategoria_Categoria_IdAndSottocategoria_Id(categoriaId, sottocategoriaId);
	}

	@Override
	public List<Prodotto> RicercaProdottto(String nome) {
		
		return (List<Prodotto>) prodottoDao.findByNomeContainingIgnoreCase(nome);
		
	}
}
