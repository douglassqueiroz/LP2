package ifms.edu.br.lp2.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifms.edu.br.lp2.model.Aluno;
import ifms.edu.br.lp2.repository.AlunoRepository;

@RestController
@RequestMapping(value = "/api/aluno")
public class AlunoResource {
    @Autowired
    AlunoRepository alunoRepository;
    
    @GetMapping(value = "/{nome}")
    public String getMeunome(@PathVariable String nome){
        return "My name is " + nome;
    }
    @GetMapping(value = "/nomesobrenome")
    public String getMeunomesobrenome(@RequestParam String nome, @RequestParam String sobrenome){
        return "My name is " + nome +  " " + sobrenome;
    }
    @PostMapping("/inserir")
    public Aluno salvarAluno(@RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }
    @GetMapping("/mostrarAlunos")
    public List<Aluno> mostrarAll(){
        return alunoRepository.findAll();
    }
}
