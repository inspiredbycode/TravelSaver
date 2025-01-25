package travel.save.approaches;

import java.io.*;
import java.net.URI;
import java.net.http.*;
/**
 * Approach 
 * actual needs two way call for access token 
 * you cant put access token in git
 * 
 *  Open questions : when do we really need URL encoding , ie for which characters 
 */
public class APIExecutor {
	
		public static void main(String[] args) {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://test.api.amadeus.com/v2/shopping/flight-offers?departureDate=2025-02-24&returnDate=2025-03-24&adults=1&max=3&originLocationCode=SFO&destinationLocationCode=DEL&nonStop=true"))
					.header("Authorization", "Bearer dQHIyLiYhJFqPA5ge86EH8emag5S")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = null;
			try {
				response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(response.body());
		}
	
}
