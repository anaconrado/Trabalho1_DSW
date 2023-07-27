package br.ufscar.dc.dsw.domain;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.ufscar.dc.dsw.validation.UniqueCnpj;

@SuppressWarnings("serial")
@Entity
@Table(name = "Locadora")
public class Locadora extends Usuario {

	@NotBlank
    @UniqueCnpj (message = "{Unique.locadora.CNPJ}")
	//trocar o tamanho depois min = 18 tambem
	@Size(min = 3, max = 18, message = "{Size.locadora.CNPJ}")
	@Column(nullable = false, unique = true, length = 60)
	private String CNPJ;

    @Column(nullable = true, length = 50)
    private String cidade;

	public String getCnpj() {
		return CNPJ;
	}

	public void setCnpj(String CNPJ) {
		this.CNPJ = CNPJ;
	}

    public String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }
}