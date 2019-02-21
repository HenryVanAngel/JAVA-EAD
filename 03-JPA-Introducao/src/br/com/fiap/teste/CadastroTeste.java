package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class CadastroTeste {

	public static void main(String[] args) {
		// Criar um gerenciador de entidades
		//Primeiro cria a fabrica:
		EntityManagerFactory fabrica =
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		//Depois, a fabrica cria os Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o Cliente
		Cliente cliente = new Cliente("Henry", 
				new GregorianCalendar(1990,Calendar.OCTOBER,11),
				"387.403.158-60", Genero.MASCULINO, null, true);
		
		//Cadastrar o Cliente
		em.persist(cliente);
		
		//Abre uma transa��o e finaliza com commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();

	}

}
