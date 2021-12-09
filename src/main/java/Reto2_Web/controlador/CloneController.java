
package Reto2_Web.controlador;

import Reto2_Web.servicio.CloneService;
import Reto2_Web.modelo.Clone;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Rodrigo
 */
@RestController
@RequestMapping("/api/clone")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class CloneController {

    @Autowired
    private CloneService service;
    /**
     *
     * @return
     */
    @GetMapping("/all")
    public List<Clone> getClone() {

        return service.getAll();

    }

    @GetMapping("/{id}")
    public Optional<Clone> getById(@PathVariable int id){

        return service.getById(id);

    }


    /**
     *
     * @param clone
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone){
        System.out.println(clone);
        return service.save(clone);

    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone clone){

        return service.update(clone);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer delete(@PathVariable Integer id){

        return  service.deleteClone(id);

    }
}
