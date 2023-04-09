package ifms.edu.br.lp2.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifms.edu.br.lp2.model.Cozinheiro;
import ifms.edu.br.lp2.repository.CozinheiroRepository;


@RestController
@RequestMapping(value = "/api/cozinheiro")
public class CozinheiroResource {
    @Autowired
    CozinheiroRepository cozinheiroRepository;

    @PostMapping("/insert")
    public Cozinheiro insert (@RequestBody @Valid Cozinheiro cozinheiro){
        return cozinheiroRepository.save(cozinheiro);
    }

    @GetMapping("mostrarCozinheiros")
    public List<Cozinheiro> mostrarAll(){
        return cozinheiroRepository.findAll();
    }

    @GetMapping("/cozinheiroid/{id}")
    public Optional<Cozinheiro> buscaCozinheiro(@PathVariable(value = "id") long id) {
        return cozinheiroRepository.findById(id);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void deleteCozinheiro(@PathVariable("id") long id) throws Exception {
        Optional<Cozinheiro> cozinheiro = cozinheiroRepository.findById(id);
        if (cozinheiro.get().getIdCozinheiro() > 0) {
            cozinheiroRepository.deleteById(id);
        } else {
            System.out.println("Cozinheiro não encontrado.");
        }
    }
    @PutMapping(value = "atualizar/{id}")
    public void atualizarCozinheiro(@PathVariable(value = "id") long id, @RequestBody Cozinheiro novoCozinheiro) {
        Optional<Cozinheiro> antigoCozinheiro = cozinheiroRepository.findById(id);
        if (antigoCozinheiro.get().getIdCozinheiro() > 0) {
            novoCozinheiro.setIdCozinheiro(antigoCozinheiro.get().getIdCozinheiro());
            cozinheiroRepository.save(novoCozinheiro);
        }
    }

}
