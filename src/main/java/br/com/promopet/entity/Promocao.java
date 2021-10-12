package br.com.promopet.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Promocao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private String desconto;
	private String loja;
	private String cupom;
	private String imagem;
	private Long positivo;
	private Long negativo;
	
	@Column(name = "link", length=4000)
	private String link;
	private Date atualizacao = new Date();
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private List<Categoria> categorias;

	

}
