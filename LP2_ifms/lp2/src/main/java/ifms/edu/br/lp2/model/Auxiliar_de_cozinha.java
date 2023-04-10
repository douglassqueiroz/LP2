package ifms.edu.br.lp2.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@javax.persistence.Entity
public class Auxiliar_de_cozinha {
    
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Código do Auxiliar de cozinha")
    private long idAuxiliar_de_Cozinha;

    @ApiModelProperty(value = "Nome do Auxiliar de cozinha")
    @Column()
    private String nome;

    @javax.validation.constraints.NotBlank(message = "O campo do CPF não pode ser em branco")
    @ApiModelProperty(value = "Insira o CPF")
    @Column()
    private String cpf;
    public String getNome(){
    return nome;
    }
}
