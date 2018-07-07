package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.descontos.Desconto;

@Entity
public class Ingresso{

	@Id
	@GenerateValue
	private INteger id;
	
	@ManyToOne
	private Sessao sessao;
	private BigDecimal preco;
	
	@ManyToOne
	private Lugar lugar;
	
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	
	public Ingresso() {}
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar) {
		this.sessao = sessao;
		this.tipoDeIngresso = tipoDeIngresso;
		this.preco = this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
	}
	   public BigDecimal getPreco() {
	    	if(this.preco==null){
	 		   return BigDecimal.ZERO;
	 	   }
	        return preco.setScale(2, RoundingMode.HALF_UP);
	    }

	    public void setPreco(BigDecimal preco) {
	        this.preco = preco;
	    }

		public Sessao getSessao() {
			return sessao;
		}

		public void setSessao(Sessao sessao) {
			this.sessao = sessao;
		}

		public Lugar getLugar() {
			return lugar;
		}

		public void setLugar(Lugar lugar) {
			this.lugar = lugar;
		}

		public TipoDeIngresso getTipoDeIngresso() {
			return tipoDeIngresso;
		}

		public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
			this.tipoDeIngresso = tipoDeIngresso;
		}
}
