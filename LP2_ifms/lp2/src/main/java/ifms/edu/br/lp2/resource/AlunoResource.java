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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifms.edu.br.lp2.model.Aluno;
import ifms.edu.br.lp2.repository.AlunoRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/aluno")
public class AlunoResource {
    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping(value = "/{nome}")
    public String getMeunome(@PathVariable String nome) {
        return "My name is " + nome;
    }

    @GetMapping(value = "/nomesobrenome")
    public String getMeunomesobrenome(@RequestParam String nome, @RequestParam String sobrenome) {
        return "My name is " + nome + " " + sobrenome;
    }

    @PostMapping("/insert")
    public Aluno insert(@RequestBody @Valid Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @GetMapping("/mostrarAlunos")
    public List<Aluno> mostrarAll() {
        return alunoRepository.findAll();
    }


    @GetMapping("/alunoid/{id}")
    public Optional<Aluno> buscaAluno(@PathVariable(value = "id") long id) {
        return alunoRepository.findById(id);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void deleteAluno(@PathVariable("id") long id) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.get().getIdAluno() > 0) {
            alunoRepository.deleteById(id);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    @PutMapping(value = "atualizar/{id}")
    public void atualizarAluno(@PathVariable(value = "id") long id, @RequestBody Aluno novoAluno) {
        Optional<Aluno> antigoAluno = alunoRepository.findById(id);
        if (antigoAluno.get().getIdAluno() > 0) {
            novoAluno.setIdAluno(antigoAluno.get().getIdAluno());
            alunoRepository.save(novoAluno);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cadastro realizado com sucesso!!"),
            @ApiResponse(code = 403, message = "Você não tem permissão de acessar este recurso!"),
            @ApiResponse(code = 500, message = "Foi gerado com exceção"),
    })
    @GetMapping(value = "/ListarAluno")
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

}
