package projectWork.service;

import java.util.List;

import projectWork.model.Categoria;

public interface CategoriaService {
    void registraCategoria(Categoria categoria);
    List<Categoria> getCategorie();
    Categoria getCategoriaById(int id);
    void cancellaCategoria(int id);
}
