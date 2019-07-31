package br.com.testecarrinho;

import java.math.BigDecimal;


public class Item {
    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    
    //testado e funcionando
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
    	this.produto = produto;
    	this.valorUnitario = valorUnitario;
    	this.quantidade = quantidade;
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    //testado e funcionando
    public Produto getProduto() {
    	return this.produto;
    	
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
    	return this.valorUnitario;
    }

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    
    //testando e funcionando
    public int getQuantidade() {
    	return this.quantidade;
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    
    //testado e funcionando
    public BigDecimal getValorTotal() {
    	BigDecimal quantidadeDeItens = new BigDecimal(getQuantidade());
    	return quantidadeDeItens.multiply(valorUnitario);

    }
    
    @Override
    public String toString() {
    	return this.produto.toString() + ", valor unitario de: " + this.getValorUnitario() +
    			" e quantidade de: " + this.getQuantidade();
    }

}
