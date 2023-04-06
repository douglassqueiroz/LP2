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

import ifms.edu.br.lp2.model.Diretor;
import ifms.edu.br.lp2.repository.DiretorRepository;

@RestController
@RequestMapping(value = "/api/diretor")
public class DiretorResource {
    @Autowired
    DiretorRepository diretorRepository;

    @GetMapping(value ="/{nome}")
    public String getMeunome(@PathVariable String nome){
        return "My name is " + nome;
    }


    @PostMapping("/insert")
    public Diretor insert(@RequestBody @Valid Diretor diretor) {
        return diretorRepository.save(diretor);
    }

    @GetMapping("/mostrarDiretores")
    public List<Diretor> mostrarAll() {
        return diretorRepository.findAll();
    }

    @GetMapping("/diretorid/{id}")
    public Optional<Diretor> buscaDiretor(@PathVariable(value = "id") long id) {
        return diretorRepository.findById(id);
    }


    @DeleteMapping(value = "/remove/{id}")
    public void deleteDiretor(@PathVariable("id") long id) throws Exception {
        Optional<Diretor> diretor = diretorRepository.findById(id);
        if (diretor.get().getIdDiretor() > 0) {
            diretorRepository.deleteById(id);
        } else {
            System.out.println("Diretor não encontrado.");
        }
    }

    @PutMapping(value = "atualizar/{id}")
    public void atualizarDiretor(@PathVariable(value = "id") long id, @RequestBody Diretor novoDiretor) {
        Optional<Diretor> antigoDiretor = diretorRepository.findById(id);
        if (antigoDiretor.get().getIdDiretor() > 0) {
            novoDiretor.setIdDiretor(antigoDiretor.get().getIdDiretor());
            diretorRepository.save(novoDiretor);
        }
    }


}
