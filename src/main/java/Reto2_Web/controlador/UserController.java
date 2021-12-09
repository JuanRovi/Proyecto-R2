
package Reto2_Web.controlador;
import Reto2_Web.servicio.UserService;
import Reto2_Web.modelo.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Rodrigo
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserService service;

    /**
     *
     * @param
     * @return
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    /**
     *
     * @param email
     * @param password
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.autenticarUsuario(email, password);
    }

    /**
     *
     * @param email
     * @return
     */
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return service.emailExists(email);
    }

    /***
     *
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update (@RequestBody User user){
        return service.update(user);
    }


    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer delete(@PathVariable("id") Integer id){
        return service.deleteById(id);
    }
}
