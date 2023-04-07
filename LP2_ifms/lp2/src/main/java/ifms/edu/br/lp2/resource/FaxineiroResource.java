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

import ifms.edu.br.lp2.model.Faxineiro;
import ifms.edu.br.lp2.repository.FaxineiroRepository;


@RestController
@RequestMapping(value = "/api/faxineiro")
public class FaxineiroResource {
    
    @Autowired
    FaxineiroRepository faxineiroRepository;

    @GetMapping("/mostrarFaxineiros")
    public List<Faxineiro> mostrarAll() {
        return faxineiroRepository.findAll();
    }
    @GetMapping("/faxineiroid/{id}")
    public Optional<Faxineiro> buscaFaxineiro(@PathVariable(value = "id") long id) {
        return faxineiroRepository.findById(id);
    }

    @PostMapping("/insert")
    public Faxineiro insert(@RequestBody @Valid Faxineiro faxineiro) {
        return faxineiroRepository.save(faxineiro);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void deleteFaxineiro(@PathVariable("id") long id) throws Exception {
        Optional<Faxineiro> faxineiro = faxineiroRepository.findById(id);
        if (faxineiro.get().getIdFaxineiro() > 0) {
            faxineiroRepository.deleteById(id);
        } else {
            System.out.println("Diretor não encontrado.");
        }
    }

    @PutMapping(value = "atualizar/{id}")
    public void atualizarFaxineiro(@PathVariable(value = "id") long id, @RequestBody Faxineiro novoFaxineiro) {
        Optional<Faxineiro> antigoFaxineiro = faxineiroRepository.findById(id);
        if (antigoFaxineiro.get().getIdFaxineiro() > 0) {
            novoFaxineiro.setIdFaxineiro(antigoFaxineiro.get().getIdFaxineiro());
            faxineiroRepository.save(novoFaxineiro);
        }
    }

}
