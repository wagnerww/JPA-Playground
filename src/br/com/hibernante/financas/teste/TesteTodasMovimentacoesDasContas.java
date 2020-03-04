package br.com.hibernante.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernante.financas.modelo.Conta;
import br.com.hibernante.financas.util.JPAUtil;

public class TesteTodasMovimentacoesDasContas {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		// join fetch = eager ou seja só vai carregar se existir movimentacoes
		// left fetch = Traz tudo de conta, mesmo que não tenha movimentações
		String jpql = "SELECT distinct c from Conta c left join fetch c.movimentacoes";

		Query query = em.createQuery(jpql);

		List<Conta> todasContas = query.getResultList();

		for (Conta conta : todasContas) {

			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacoes: ");
			System.out.println(conta.getMovimentacoes());

		}

		em.getTransaction().commit();
		em.close();
	}

}
