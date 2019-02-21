package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class RefreshTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Atualizar o objeto com os valores do banco
		//Pesquisar um Cliente
		Cliente cliente = em.find(Cliente.class,1);
		System.out.println("Valor do banco: " + cliente.getNome());
		//Alterar o Valor do nome no Java
		cliente.setNome("Farofas");
		System.out.println("Nome modificado no Java: "+ cliente.getNome());
		//Realizar o Refresh
		em.refresh(cliente);
		//Exibir o nome
		System.out.println("Nome após o refresh: " + cliente.getNome());
		
		em.close();
		fabrica.close();
		

	}

}
