package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);

		TypedQuery<Double> typedQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);

		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Double> medias = typedQuery.getResultList();;
		
		for (Double double1 : medias) {
			
			System.out.println(double1);
		}
		
		em.getTransaction().commit();
		em.close();
	}

}
