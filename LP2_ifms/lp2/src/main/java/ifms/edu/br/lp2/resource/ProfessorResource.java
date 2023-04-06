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

import ifms.edu.br.lp2.model.Professor;
import ifms.edu.br.lp2.repository.ProfessorRepository;


@RestController
@RequestMapping(value = "/api/professor")
public class ProfessorResource {
    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping("/mostrarProfessores")
    public List<Professor> mostrarAll(){
        return professorRepository.findAll();
    }
    @GetMapping("/professorid/{id}")
    public Optional<Professor> buscaProfessor(@PathVariable (value = "id") long id) {
        return professorRepository.findById(id);
    }

    @PostMapping("/insert")
    public Professor insert(@RequestBody @Valid Professor professor) {
        return professorRepository.save(professor);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void deleteProfessor(@PathVariable("id") long id) throws Exception {
        Optional<Professor>  professor  = professorRepository.findById(id);
        if (professor.get().getIdProfessor() > 0) {
            professorRepository.deleteById(id);
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    @PutMapping(value = "atualizar/{id}")
    public void atualizarProfessor(@PathVariable(value = "id") long id, @RequestBody Professor novoProfessor) {
        Optional<Professor> antigoProfessor = professorRepository.findById(id);
        if (antigoProfessor.get().getIdProfessor() > 0) {
            novoProfessor.setIdProfessor(antigoProfessor.get().getIdProfessor());
            professorRepository.save(novoProfessor);
        }
    }

    
}