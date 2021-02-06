package desafio1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgramaTeste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("minha-persistence-unit");
		EntityManager em = emf.createEntityManager();
		
		List<Usuario> lista = em.createQuery("FROM Usuario", Usuario.class).getResultList();
        
		for (Usuario objeto : lista) {
			System.out.println("objeto no banco: " + objeto.getNome());
		}
		
		
		// Persistir objeto no banco
		Usuario objeto = new Usuario();
		objeto.setNome("teste");
		
		
		em.getTransaction().begin();
		em.persist(objeto);
		em.getTransaction().commit();
		        
		// Fechar EntityManager e EntityManagerFactory
		em.close();
		emf.close();
		
		

	}

}
