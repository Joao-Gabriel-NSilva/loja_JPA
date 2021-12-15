package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(celulares);
		celulares.setNome("XAP");
		
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);
		celulares.setNome("123");
		em.flush();
		em.remove(celulares);
		em.flush();
		
	}

}
