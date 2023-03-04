package ifms.edu.br.lp2.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@javax.persistence.Entity
public class Aluno {
    
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Código do Aluno")
    private long idAluno;

    @ApiModelProperty(value = "Nome do Aluno")
    @Column()
    private String nome;

    @javax.validation.constraints.NotBlank(message = "O campo do CPF não pode ser em branco")
    @ApiModelProperty(value = "Insira o CPF")
    @Column()
    private String cpf;
    public String getNome(){
    return nome;
    }

    public void setNome(String newNome){
        this.nome = newNome;
    }
        
}
