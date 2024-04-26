package projectWork.Service;

import java.util.List;

import projectWork.Model.Sottocategoria;

public interface SottocategoriaService {
	void registraSottocategoria(Sottocategoria sottocategoria);
	List<Sottocategoria> getSottocategorie();
	Sottocategoria getSottocategoriaById(int id);
	void cancellaSottocategoria(int id);
}