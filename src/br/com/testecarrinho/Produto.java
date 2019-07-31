package br.com.testecarrinho;

public class Produto {
    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    
    //testado e funcionando
    public Produto(Long codigo, String descricao) {
    	this.codigo = codigo;
    	this.descricao = descricao;
    }

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    //testado e funcionando
    public Long getCodigo() {
    	return this.codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    
    //testado e funcionando
    public String getDescricao() {
    	return this.descricao;
    }
    
    @Override
    public String toString() {
    	return "o produto tem a descrição: " + this.getDescricao()
    			+" e código: " + this.getCodigo();
    }

}
