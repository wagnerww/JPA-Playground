package br.com.hibernante.financas.teste;

import javax.persistence.EntityManager;

import br.com.hibernante.financas.modelo.Cliente;
import br.com.hibernante.financas.modelo.Conta;
import br.com.hibernante.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		cliente.setNome("Cliente 1");
		cliente.setEndereco("Rua x");
		cliente.setProfissao("Professor");

		/* vai dar erro por causa da constraint de conta que é unica
		 * Cliente cliente2 = new Cliente();
		cliente2.setNome("Novo 1");
		cliente2.setEndereco("Rua x");
		cliente2.setProfissao("Mecanico"); */

		Conta conta = new Conta();
		conta.setId(2);

		cliente.setConta(conta);
		//cliente2.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		em.persist(cliente);
		//em.persist(cliente2);

		em.getTransaction().commit();
		em.close();

	}

}
