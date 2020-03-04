package br.com.hibernante.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernante.financas.modelo.Conta;
import br.com.hibernante.financas.modelo.Movimentacao;
import br.com.hibernante.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);

		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta ORDER BY m.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);

		List<Movimentacao> resultados = query.getResultList();

		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao " + movimentacao.getDescricao());
			System.out.println("Conta.id " + movimentacao.getConta().getId());
		}

		em.getTransaction().commit();
		em.close();
	}
}
