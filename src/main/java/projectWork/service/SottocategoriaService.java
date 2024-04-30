package projectWork.service;

import java.util.List;

import projectWork.model.Sottocategoria;

public interface SottocategoriaService {
	
	List<Sottocategoria> getSottocategorie();
	Sottocategoria getSottocategoriaById(int id);
	
}
