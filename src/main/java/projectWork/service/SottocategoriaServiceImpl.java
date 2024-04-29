package projectWork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectWork.dao.SottocategoriaDao;
import projectWork.model.Sottocategoria;

@Service
public class SottocategoriaServiceImpl implements SottocategoriaService{
	
	@Autowired
	private SottocategoriaDao sottocategoriaDao;

	@Override
	public void registraSottocategoria(Sottocategoria sottocategoria) {
		sottocategoriaDao.save(sottocategoria);
	}

	@Override
	public List<Sottocategoria> getSottocategorie() {
		return (List<Sottocategoria>) sottocategoriaDao.findAll();
	}

	@Override
	public Sottocategoria getSottocategoriaById(int id) {
		return sottocategoriaDao.findById(id).get();
	}

	@Override
	public void cancellaSottocategoria(int id) {
		sottocategoriaDao.deleteById(id);
	}
	
}
