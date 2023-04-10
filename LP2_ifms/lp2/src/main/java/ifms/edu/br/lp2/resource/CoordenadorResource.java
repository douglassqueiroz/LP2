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

import ifms.edu.br.lp2.model.Coordenador;
import ifms.edu.br.lp2.repository.CoordenadorRepository;

@RestController
@RequestMapping(value = "/api/coordenador")
public class CoordenadorResource {
    @Autowired
    CoordenadorRepository coordenadorRepository;

    @PostMapping("/insert")
    public Coordenador insert(@RequestBody @Valid Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }

    @GetMapping("/mostrarCoordenadores")
    public List<Coordenador> mostrarAll() {
        return coordenadorRepository.findAll();
    }

    @GetMapping("/coordenadorid/{id}")
    public Optional<Coordenador> buscaCoordenador(@PathVariable(value = "id") long id) {
        return coordenadorRepository.findById(id);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void deleteCoordenador(@PathVariable("id") long id) throws Exception {
        Optional<Coordenador> coordenador = coordenadorRepository.findById(id);
        if (coordenador.get().getIdCoordenador() > 0) {
            coordenadorRepository.deleteById(id);
        } else {
            System.out.println("Coordenador não encontrado.");
        }
    }

    @PutMapping(value = "atualizar/{id}")
    public void atualizarCoordenador(@PathVariable(value = "id") long id, @RequestBody Coordenador novoCoordenador) {
        Optional<Coordenador> antigoCoordenador = coordenadorRepository.findById(id);
        if (antigoCoordenador.get().getIdCoordenador() > 0) {
            novoCoordenador.setIdCoordenador(antigoCoordenador.get().getIdCoordenador());
            coordenadorRepository.save(novoCoordenador);
        }
    }





}
