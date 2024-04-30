package projectWork.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import projectWork.model.Prodotto;

public interface ProdottoDao extends CrudRepository<Prodotto, Integer>{

	 List<Prodotto> findBySottocategoria_Categoria_IdAndSottocategoria_Id(Integer categoriaId, Integer sottocategoriaId);
	
}
