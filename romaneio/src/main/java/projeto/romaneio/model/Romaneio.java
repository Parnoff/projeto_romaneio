package projeto.romaneio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Romaneio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String dt_emissao;
	
	private String dt_saida;
	
	//@ForeignKey(name="item_id")
	@ManyToOne
	@JoinColumn(nullable = false)
	private Item item;
	
	//@ForeignKey(name="cliente_id")
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;
	
	private Integer quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDt_emissao() {
		return dt_emissao;
	}

	public void setDt_emissao(String dt_emissao) {
		this.dt_emissao = dt_emissao;
	}

	public String getDt_saida() {
		return dt_saida;
	}

	public void setDt_saida(String dt_saida) {
		this.dt_saida = dt_saida;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
