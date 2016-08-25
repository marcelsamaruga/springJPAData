package br.com.template.projectTemplate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "OF_MATERIA_PRIMA")

// rule: the name of the NamedQuery: first the entity + function. Add the function in the repository
@NamedQuery(name="OfMateriaPrima.allDesc", query = "SELECT ofMP FROM OfMateriaPrima ofMP ORDER BY ofMP.dataEmissao DESC")

@NamedNativeQueries(
		@NamedNativeQuery(name="OfMateriaPrima.allDescSQL", 
						  query="SELECT * FROM of_materia_prima ORDER BY data_emissao DESC", 
						  resultClass = OfMateriaPrima.class)
)

public class OfMateriaPrima implements Serializable {

	private static final long serialVersionUID = -6932041657556537269L;

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "numero_completo")
	private String numeroCompleto;


	@JoinColumn(name = "ID_EMBALAGEM")
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Embalagem.class)
	private Embalagem embalagem;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DATA_EMISSAO", updatable = false, columnDefinition = "DATE")
	private Date dataEmissao;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @return the embalagem
	 */
	public Embalagem getEmbalagem() {
		return embalagem;
	}



	/**
	 * @param embalagem the embalagem to set
	 */
	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
	}



	/**
	 * @return the dataEmissao
	 */
	public Date getDataEmissao() {
		return dataEmissao;
	}



	/**
	 * @param dataEmissao the dataEmissao to set
	 */
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}



	/**
	 * @return the numeroCompleto
	 */
	public String getNumeroCompleto() {
		return numeroCompleto;
	}



	/**
	 * @param numeroCompleto the numeroCompleto to set
	 */
	public void setNumeroCompleto(String numeroCompleto) {
		this.numeroCompleto = numeroCompleto;
	}



	@Override
	public String toString() {
		return "OF[numero=" + numeroCompleto + "]";
	}
}
