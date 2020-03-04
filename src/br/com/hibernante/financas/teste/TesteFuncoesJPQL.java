package br.com.hibernante.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.hibernante.financas.modelo.Conta;
import br.com.hibernante.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);

		String jpql = "SELECT sum(m.valor) FROM Movimentacao m WHERE m.conta = :pConta";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);

		BigDecimal soma = (BigDecimal) query.getSingleResult();

		System.out.println("Soma é " + soma);

		String jpql2 = "SELECT avg(m.valor) FROM Movimentacao m WHERE m.conta = :pConta";
		Query query2 = em.createQuery(jpql2);
		query2.setParameter("pConta", conta);

		Double media = (Double) query2.getSingleResult();

		System.out.println("Média é " + media);

		String jpql3 = "SELECT avg(m.valor) FROM Movimentacao m WHERE m.conta = :pConta GROUP BY day(m.data), month(m.data), year(m.data)";

		//Tipando a query para deixar mais "seguro"
		TypedQuery<Double> query3 = em.createQuery(jpql3, Double.class);
		query3.setParameter("pConta", conta);

		List<Double> medias = (List<Double>) query3.getResultList();

		System.out.println("Média é " + medias);

		em.getTransaction().commit();
		em.close();
	}
}
