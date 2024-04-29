package projectWork.service;

import java.util.List;

import projectWork.model.Sottocategoria;

public interface SottocategoriaService {
	void registraSottocategoria(Sottocategoria sottocategoria);
	List<Sottocategoria> getSottocategorie();
	Sottocategoria getSottocategoriaById(int id);
	void cancellaSottocategoria(int id);
}
