package br.com.hibernante.financas.teste;

import javax.persistence.EntityManager;

import br.com.hibernante.financas.modelo.Conta;
import br.com.hibernante.financas.modelo.Movimentacao;
import br.com.hibernante.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Movimentacao movimentacao = em.find(Movimentacao.class, 2);
		Conta conta = movimentacao.getConta();

		System.out.println(conta.getTitular());

		System.out.println(conta.getMovimentacoes().size());

		em.getTransaction().commit();
		em.close();
	}

}
