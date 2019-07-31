package br.com.testecarrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class CarrinhoFactory {
	// lista de carrinhos que forem criados

	private List<CarrinhoCompras> listaDeCarrinhos = new ArrayList<CarrinhoCompras>();

	// Método criar que checa se já existe outro carrinho com a mesma identificacao do Cliente
	// TESTADO E FUNCIONANDO
	public CarrinhoCompras criar(String identificacaoCliente) {

		// checando se a identificacao do Cliente ja existe em outro carrinho
		for (int i = 0; i < listaDeCarrinhos.size(); i++) {

			if (listaDeCarrinhos.get(i).getIdentificacaoCliente().equals(identificacaoCliente)) {
				System.out.println("já existe");
				return listaDeCarrinhos.get(i);
			}
		}
		// caso nao exista, cria um novo e adiciona na lista de carrinhos
		CarrinhoCompras carrinho = new CarrinhoCompras(identificacaoCliente);
		listaDeCarrinhos.add(carrinho);
		return carrinho;
	}

	/*
	 * Retorna o valor do ticket médio no momento da chamada ao método. O valor do ticket médio é a
	 * soma do valor total de todos os carrinhos de compra dividido pela quantidade de carrinhos de
	 * compra. O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
	 * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
	 *
	 * @return BigDecimal
	 */

	//testado e funcionando
	public BigDecimal getValorTicketMedio() {
		// inicializando o total de todas as compras
		BigDecimal totalDasCompras = new BigDecimal(0);

		// iterando sobre os valores de cara carrinho
		for (int i = 0; i < listaDeCarrinhos.size(); i++) {
			System.out.println("passando por todos os carrinhos");
			System.out.println(listaDeCarrinhos.get(i));
			BigDecimal totalDoCarrinho = listaDeCarrinhos.get(i).getValorTotal();
			System.out.println("total do carrinho é: " + totalDoCarrinho);
			totalDasCompras = totalDasCompras.add(totalDoCarrinho);
		}
		System.out.println("total das compras é: " + totalDasCompras);
		// atribuindo o valor da quantidade de carrinhos existentes
		BigDecimal quantidadeDeCarrinhos = new BigDecimal(listaDeCarrinhos.size());
		System.out.println("quantidade de carrinhos: " + quantidadeDeCarrinhos);

		// dividindo para chegar no ticket medio
		BigDecimal ticketMedio = totalDasCompras.divide(quantidadeDeCarrinhos);
		
		BigDecimal ticketMedioArredondado = ticketMedio.setScale(2, RoundingMode.HALF_UP);

		return ticketMedioArredondado;

	}

	/**
	 * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar. Deve
	 * ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos
	 * de compras.
	 *
	 * @param identificacaoCliente
	 * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um
	 *         carrinho de compras e e false caso o cliente não possua um carrinho.
	 */
	
	//TESTADO E FUNCIONA
	public boolean invalidar(String identificacaoCliente) {

		if (findByIdentificacaoCliente(identificacaoCliente) == null) {
			listaDeCarrinhos.remove(findByIdentificacaoCliente(identificacaoCliente));
			return false;
		}
		return true;

	}

	//TESTADO E FUNCIONA
	public CarrinhoCompras findByIdentificacaoCliente(String identificacaoCliente) {

		for (int i = 0; i < listaDeCarrinhos.size(); i++) {
			if (listaDeCarrinhos.get(i).getIdentificacaoCliente().equals(identificacaoCliente)) {
				return listaDeCarrinhos.get(i);
			}
		}
		return null;

	}

	//TESTADO E FUNCIONA
	public List<CarrinhoCompras> getListaDeCarrinhos() {
		return listaDeCarrinhos;
	}
	

}
