package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class PesquisaTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar um cliente com código 1
		
		Cliente cliente = em.find(Cliente.class,1);
		
		
		System.out.println(cliente.getCpf());
		//Modificar o CPF no banco de dados
		cliente.setCpf("343.381.223-70");
		
		em.getTransaction().begin();
		em.getTransaction().commit();

		System.out.println(cliente.getCpf());
		
		em.close();
		fabrica.close();

	}

}
