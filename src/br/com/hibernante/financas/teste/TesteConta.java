package br.com.hibernante.financas.teste;

import javax.persistence.EntityManager;

import br.com.hibernante.financas.modelo.Conta;
import br.com.hibernante.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Wagner Ricardo");
		conta.setAgencia("123");
		conta.setBanco("Caixa Economica");
		conta.setNumero("456");

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();

		em.close();

	}

}
