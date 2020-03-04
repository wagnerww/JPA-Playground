package br.com.hibernante.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.hibernante.financas.modelo.Conta;
import br.com.hibernante.financas.modelo.Movimentacao;
import br.com.hibernante.financas.modelo.TipoMovimentacao;
import br.com.hibernante.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Wagner Ricardo");
		conta.setAgencia("897");
		conta.setBanco("Itau");
		conta.setNumero("456");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.0"));

		movimentacao.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		em.persist(conta);
		em.persist(movimentacao);

		em.getTransaction().commit();

		em.close();

	}
}
