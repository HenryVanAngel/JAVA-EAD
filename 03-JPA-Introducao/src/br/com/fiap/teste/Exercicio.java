package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Estado;
import br.com.fiap.entity.Produto;

public class Exercicio {

	public static void main(String[] args) {
		// Realizar o CRUD para o Produto
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//CADASTRAR
		Produto p = new Produto("MACBOOK", 3, Estado.NOVO, 
				new GregorianCalendar(2030,Calendar.APRIL,4), 
				new GregorianCalendar(2019,Calendar.JANUARY,1), 10000, null);
		
		em.persist(p);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println(p.getNome());
		//PESQUISAR
		Produto pp = em.find(Produto.class, 1);
		
		System.out.println(pp.getNome());
		//ATUALIZAR
		Produto pa = new Produto(1, "Sony VAIO", 3, Estado.NOVO, 
				new GregorianCalendar(2030, Calendar.DECEMBER,1), 
				new GregorianCalendar(2019, Calendar.AUGUST,2),
				8000, null);
		
		em.merge(pa);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println(pa.getNome());
		
		//REMOVER
		Produto p3 = em.find(Produto.class, 1);
		em.remove(p3);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
