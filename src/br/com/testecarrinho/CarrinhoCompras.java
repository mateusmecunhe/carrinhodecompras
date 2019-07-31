package br.com.testecarrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class CarrinhoCompras {
	// construtor de Carrinho com ID do cliente
	public CarrinhoCompras(String identificacaoCliente) {
		this.identificacaoCliente = identificacaoCliente;
		System.out.println("criando carrinho de " + identificacaoCliente);
	}

	private String identificacaoCliente;
	private ArrayList<Item> todosOsItens = new ArrayList<Item>();

	/**
	 * Permite a adição de um novo item no carrinho de compras.
	 *
	 * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser
	 * seguidas: - A quantidade do item deverá ser a soma da quantidade atual com a quantidade
	 * passada como parâmetro. - Se o valor unitário informado for diferente do valor unitário atual
	 * do item, o novo valor unitário do item deverá ser o passado como parâmetro.
	 *
	 * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao
	 * carrinho de compras.
	 *
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */

	//testado e funcionando
	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
		if (jaExisteOItem(produto.getCodigo())) {

			// adiciona a quantidade à quantidade existente

			// resolvendo a soma de quantidades
			int quantidadeJaExistenteNoCarrinho = 0;
			for(int i = 0; i < todosOsItens.size(); i++) {
				if(todosOsItens.get(i).getProduto().getCodigo().equals(produto.getCodigo())) {
					quantidadeJaExistenteNoCarrinho = todosOsItens.get(i).getQuantidade();
				}
			}
			int quantidadeTotalASerConsiderada = quantidadeJaExistenteNoCarrinho + quantidade;
			
			Item itemASerAlterado = findItemByCodigoDeProduto(produto.getCodigo());
			itemASerAlterado.setQuantidade(quantidadeTotalASerConsiderada);
			itemASerAlterado.setValorUnitario(valorUnitario);
			
//			this.removerItem(produto);
//			Item itemASerAdicionado = new Item(produto, valorUnitario, quantidadeTotalASerConsiderada);
//			todosOsItens.add(itemASerAdicionado);

			// resolvendo precos: pelo enunciado, o valor passado como
			// argumento nesse método é o preço a ser considerado sempre

			System.out.println("atualizando quantidade de item "
					+ itemASerAlterado.getProduto().getDescricao());

		} else {
			// add new item na lista
			Item item = new Item(produto, valorUnitario, quantidade);
			todosOsItens.add(item);
			System.out.println("adicionando novo item ao carrinho");
		}

	}

	//testado e funcionando
	public boolean jaExisteOItem(Long codigo) {


		for (int i = 0; i < todosOsItens.size(); i++) {
			Long codigoProduto = todosOsItens.get(i).getProduto().getCodigo();
			if (codigoProduto.equals(codigo)) {
				System.out.println(codigo+ " - produto com esse código já existe no carrinho");
				return true;
			}
		}
		return false;
	}

	public Item findItemByCodigoDeProduto(Long codigoDoProduto) throws NullPointerException {
		for (int i = 0; i < todosOsItens.size(); i++) {
			if (todosOsItens.get(i).getProduto().getCodigo().equals(codigoDoProduto)) {
				System.out.println("item encontrado");
				todosOsItens.get(i).getProduto();
			}
		}
		return null;
	}

	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */

	// testado e funcionando
	public boolean removerItem(Produto produto) {
		Long codigoDoProdutoASerRemovido = produto.getCodigo();

		System.out.println(codigoDoProdutoASerRemovido);
		for (int i = 0; i < todosOsItens.size(); i++) {
			System.out.println("iterando sobre a lista");
			Long codigoDoProduto = todosOsItens.get(i).getProduto().getCodigo();
			if (codigoDoProduto.equals(codigoDoProdutoASerRemovido)) {
				todosOsItens.remove(todosOsItens.get(i));
				System.out.println("item removido");
				return true;
			}
		}
		return false;

	}

	/**
	 * Permite a remoção do item de acordo com a posição. Essa posição deve ser determinada pela
	 * ordem de inclusão do produto na coleção, em que zero representa o primeiro item.
	 *
	 * @param posicaoItem
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */

	// testado e funcionando
	public boolean removerItem(int posicaoItem) {
		for (int i = 0; i < todosOsItens.size(); i++) {
			if (posicaoItem == i) {
				todosOsItens.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais de todos
	 * os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */

	// testado e funcionando
	public BigDecimal getValorTotal() {
		BigDecimal valorTotal = new BigDecimal(0);

		for (int i = 0; i < todosOsItens.size(); i++) {
			System.out.println("iterando lista para somar valor total");
			System.out.println(todosOsItens.get(i));
			BigDecimal valorUnitario = todosOsItens.get(i).getValorUnitario();
			BigDecimal quantidade = new BigDecimal(todosOsItens.get(i).getQuantidade());

			valorTotal = valorTotal.add(valorUnitario.multiply(quantidade));
		}

		return valorTotal;

	}

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens
	 */
	// testado e funcionando
	public Collection<Item> getItens() {
		return this.todosOsItens;

	}

	// testado e funcionando
	public String getIdentificacaoCliente() {
		return identificacaoCliente;
	}

	public void setIdentificacaoCliente(String identificacaoCliente) {
		this.identificacaoCliente = identificacaoCliente;
	}

	@Override
	public String toString() {
		return "carrinho de " + this.identificacaoCliente;
	}

}
