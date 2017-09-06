package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Caio Ferreira");
		conta.setBanco("HSBC");
		conta.setNumero("33221");
		conta.setAgencia("321");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("conta de luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123.9"));
		
		movimentacao.setConta(conta);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.persist(movimentacao);
		manager.getTransaction().commit();
		
		manager.close();

	}

}
