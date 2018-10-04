package nc.test;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import nc.client.ClientRest;
import nc.metier.modele.Categorie;

public class JerseyTest {
	private ClientRest client=new ClientRest();

	@Test
	public void test()throws Exception {
		Response respCategories=client.listCategories();
		String serC=respCategories.readEntity(String.class);
		System.out.println("Toutes les catégories");
		System.out.println("---------------------");
		System.out.println(serC+"\n\n");
		
		Response produits=client.listProduits();
		String serP=produits.readEntity(String.class);
		System.out.println("Tous les produits");
		System.out.println("-----------------");
		System.out.println(serP+"\n\n");
		
		//Dé-serialisation
		//par Jackson
		ObjectMapper mapper=new ObjectMapper();
		Categorie[] categories=mapper.readValue(serC, Categorie[].class);
		System.out.println("Dé-serialisation de toutes les categories");
		System.out.println("-----------------------------------------");
		for(Categorie c : categories) {
			System.out.print("id : " + c.getIdCategorie() + " nom : " + c.getNomCategorie()+"\n");
		}
	}

}
