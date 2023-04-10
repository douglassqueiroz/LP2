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

import ifms.edu.br.lp2.model.Auxiliar_de_cozinha;
import ifms.edu.br.lp2.repository.Auxiliar_de_cozinhaRepository;

@RestController
@RequestMapping(value = "/api/auxiliardecozinha")
public class Auxiliar_de_cozinhaResource {
    @Autowired
    Auxiliar_de_cozinhaRepository auxiliar_de_cozinhaRepository;

    @PostMapping("/insert")
    public Auxiliar_de_cozinha insert(@RequestBody @Valid Auxiliar_de_cozinha auxiliar_de_cozinha) {
        return auxiliar_de_cozinhaRepository.save(auxiliar_de_cozinha);
    }
    
    @GetMapping("/mostrarAuxiliardecozinha")
    public List<Auxiliar_de_cozinha> mostrarAll() {
        return auxiliar_de_cozinhaRepository.findAll();
    }


    @GetMapping("/auxiliardecozinhaid/{id}")
    public Optional<Auxiliar_de_cozinha> buscaAuxiliardecozinha(@PathVariable(value = "id") long id) {
        return auxiliar_de_cozinhaRepository.findById(id);
    }


    @DeleteMapping(value = "/remove/{id}")
    public void deleteAuxiliardecozinha(@PathVariable("id") long id) throws Exception {
        Optional<Auxiliar_de_cozinha> auxiliar_de_cozinha = auxiliar_de_cozinhaRepository.findById(id);
        if (auxiliar_de_cozinha.get().getIdAuxiliar_de_Cozinha() > 0) {
            auxiliar_de_cozinhaRepository.deleteById(id);
        } else {
            System.out.println("Auxiliar de cozinha não encontrado.");
        }
    }

    @PutMapping(value = "atualizar/{id}")
    public void atualizarAuxiliardecozinha(@PathVariable(value = "id") long id, @RequestBody Auxiliar_de_cozinha novoAuxiliar_de_cozinha) {
        Optional<Auxiliar_de_cozinha> antigoAuxiliar_de_cozinha = auxiliar_de_cozinhaRepository.findById(id);
        if (antigoAuxiliar_de_cozinha.get().getIdAuxiliar_de_Cozinha() > 0) {
            novoAuxiliar_de_cozinha.setIdAuxiliar_de_Cozinha(antigoAuxiliar_de_cozinha.get().getIdAuxiliar_de_Cozinha());
            auxiliar_de_cozinhaRepository.save(novoAuxiliar_de_cozinha);
        }
    }
}