package nc.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ClientRest {
	private static final String REST_URI="http://localhost:8080/AppJaxrsJersey/rest";
	private Client client=ClientBuilder.newClient();
	
	public Response listCategories() {
		return client.target(REST_URI).
			path("catalogue").
			path("categories").
			request(MediaType.APPLICATION_JSON).
			get();
			
	}
	
	public Response listProduits() {
		return client.target(REST_URI).
			path("catalogue").
			path("produits").
			request(MediaType.APPLICATION_JSON).
			get();
			
	}

}
