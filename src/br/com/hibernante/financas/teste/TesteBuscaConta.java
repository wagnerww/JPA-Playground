package br.com.hibernante.financas.teste;

import javax.persistence.EntityManager;

import br.com.hibernante.financas.modelo.Conta;
import br.com.hibernante.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 1);

		conta.setTitular("João");
		conta.setAgencia("456");

		System.out.println(conta.getTitular());

		em.getTransaction().commit();
		em.close();

		EntityManager em2 = new JPAUtil().getEntityManager();

		em2.getTransaction().begin();

		conta.setTitular("Novo titular");
		em2.merge(conta);

		em2.getTransaction().commit();
		em2.close();

	}
}
