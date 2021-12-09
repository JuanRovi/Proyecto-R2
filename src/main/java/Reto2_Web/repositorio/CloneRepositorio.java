
package Reto2_Web.repositorio;

import Reto2_Web.interfaces.InterfaceClone;
import Reto2_Web.modelo.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodrigo
 */
@Repository
public class CloneRepositorio {
    @Autowired
    private InterfaceClone repository;

    public List<Clone> getAll() {
        return repository.findAll();
    }

    public Optional<Clone>  getCloneById(int id){

        return repository.findById(id);

    }

    public Clone save(Clone clone) {

        return repository.save(clone);
    }

    public void delete(Integer id){

        repository.deleteById(id);

    }
}
