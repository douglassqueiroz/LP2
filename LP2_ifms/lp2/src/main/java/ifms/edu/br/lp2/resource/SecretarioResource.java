package ifms.edu.br.lp2.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifms.edu.br.lp2.model.Secretario;
import ifms.edu.br.lp2.repository.SecretarioRepository;




@RestController
@RequestMapping(value = "/api/secretario")
public class SecretarioResource {
    
    @Autowired
    SecretarioRepository secretarioRepository;

    @GetMapping("/mostrarSecretarios")
    public List<Secretario> mostrarAll(){
        return secretarioRepository.findAll();
    }

    @GetMapping("/secretarioid/{id}")
    public Optional<Secretario> buscaSecretario(@PathVariable (value = "id") long id) {
        return secretarioRepository.findById(id);
    }

    @PostMapping("/insert")
    public Secretario insert(@RequestBody @Valid Secretario secretario) {
        return secretarioRepository.save(secretario);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void deleteSecretario(@PathVariable("id") long id) throws Exception {
        Optional<Secretario>  secretario  = secretarioRepository.findById(id);
        if (secretario.get().getIdSecretario() > 0) {
            secretarioRepository.deleteById(id);
        } else {
            System.out.println("Secretario não encontrado.");
        }
    }

    @PutMapping(value = "atualizar/{id}")
    public void atualizarSecretario(@PathVariable(value = "id") long id, @RequestBody Secretario novoSecretario) {
        Optional<Secretario> antigoSecretario= secretarioRepository.findById(id);
        if (antigoSecretario.get().getIdSecretario() > 0) {
            novoSecretario.setIdSecretario(antigoSecretario.get().getIdSecretario());
            secretarioRepository.save(novoSecretario);
        }
    }

}
