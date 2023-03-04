package ifms.edu.br.lp2.model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Código do Aluno")
    private long idAluno;
    @ApiModelProperty(value = "Nome do Aluno")
    private String nome;

    public String getNome(){
    return nome;
    }
    public void setNome(String newNome){
        this.nome = newNome;
    }
        
}
