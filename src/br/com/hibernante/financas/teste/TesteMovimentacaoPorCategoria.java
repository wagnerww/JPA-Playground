package br.com.hibernante.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernante.financas.modelo.Categoria;
import br.com.hibernante.financas.modelo.Movimentacao;
import br.com.hibernante.financas.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Categoria Categoria = new Categoria();
		Categoria.setId(1);

		String jpql = "SELECT m FROM Movimentacao m JOIN m.categoria c WHERE c = :pCategoria";
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", Categoria);

		List<Movimentacao> resultados = query.getResultList();

		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao " + movimentacao.getDescricao());
			System.out.println("Conta.id " + movimentacao.getConta().getId());
		}

		em.getTransaction().commit();
		em.close();
	}
}
