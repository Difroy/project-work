package projectWork.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectWork.Dao.CategoriaDao;
import projectWork.Model.Categoria;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public void registraCategoria(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public List<Categoria> getCategorie() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public Categoria getCategoriaById(int id) {
        return categoriaDao.findById(id).get();
    }

    @Override
    public void cancellaCategoria(int id) {
        categoriaDao.deleteById(id);
    }
}
