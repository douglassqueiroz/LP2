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

import ifms.edu.br.lp2.model.DiretorSubjacente;
import ifms.edu.br.lp2.repository.DiretorSubjacenteRepository;

@RestController
@RequestMapping(value = "/api/diretorSubjacente")
public class DiretorSubjacenteResource {
    @Autowired
    DiretorSubjacenteRepository diretorSubjacenteRepository;


    @PostMapping("/insert")
    public DiretorSubjacente insert(@RequestBody @Valid DiretorSubjacente diretorSubjacente) {
        return diretorSubjacenteRepository.save(diretorSubjacente);
    }

    @GetMapping("/mostrarDiretoresSubjacentes")
    public List<DiretorSubjacente> mostrarAll() {
        return diretorSubjacenteRepository.findAll();
    }


    @GetMapping("/diretorSubjacenteid/{id}")
    public Optional<DiretorSubjacente> buscaDiretorSubjacente(@PathVariable(value = "id") long id) {
        return diretorSubjacenteRepository.findById(id);
    }


    @DeleteMapping(value = "/remove/{id}")
    public void deleteDiretorSubjacente(@PathVariable("id") long id) throws Exception {
        Optional<DiretorSubjacente> diretorSubjacente = diretorSubjacenteRepository.findById(id);
        if (diretorSubjacente.get().getIdDiretorSubjacente() > 0) {
            diretorSubjacenteRepository.deleteById(id);
        } else {
            System.out.println("Diretor Subjacente não encontrado.");
        }
    }


    @PutMapping(value = "atualizar/{id}")
    public void atualizarDiretorSubjacente(@PathVariable(value = "id") long id, @RequestBody DiretorSubjacente novoDiretorSubjacente) {
        Optional<DiretorSubjacente> antigoDiretorSubjacente = diretorSubjacenteRepository.findById(id);
        if (antigoDiretorSubjacente.get().getIdDiretorSubjacente() > 0) {
            novoDiretorSubjacente.setIdDiretorSubjacente(antigoDiretorSubjacente.get().getIdDiretorSubjacente());
            diretorSubjacenteRepository.save(novoDiretorSubjacente);
        }
    }

}
