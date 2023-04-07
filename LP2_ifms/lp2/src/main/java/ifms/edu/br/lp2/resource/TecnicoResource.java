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

import ifms.edu.br.lp2.model.Tecnico;
import ifms.edu.br.lp2.repository.TecnicoRepository;


@RestController
@RequestMapping(value = "/api/tecnico")
public class TecnicoResource {
    
    @Autowired
    TecnicoRepository tecnicoRepository;

    @GetMapping("/mostrarTecnicos")
    public List<Tecnico> mostrarAll(){
        return tecnicoRepository.findAll();
    }

    @GetMapping("/tecnicoid/{id}")
    public Optional<Tecnico> buscaTecnico(@PathVariable (value = "id") long id) {
        return tecnicoRepository.findById(id);
    }


    @PostMapping("/insert")
    public Tecnico insert(@RequestBody @Valid Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void deleteTecnico(@PathVariable("id") long id) throws Exception {
        Optional<Tecnico> tecnico  = tecnicoRepository.findById(id);
        if (tecnico.get().getIdTecnico()> 0) {
            tecnicoRepository.deleteById(id);
        } else {
            System.out.println("Secretario não encontrado.");
        }
    }


    @PutMapping(value = "atualizar/{id}")
    public void atualizarTecnico(@PathVariable(value = "id") long id, @RequestBody Tecnico novoTecnico) {
        Optional<Tecnico> antigoTecnico= tecnicoRepository.findById(id);
        if (antigoTecnico.get().getIdTecnico() > 0) {
            novoTecnico.setIdTecnico(antigoTecnico.get().getIdTecnico());
            tecnicoRepository.save(novoTecnico);
        }
    }

}
