package travel.save.approaches;

import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightAvailability;

/**
 * 
 */
public class JavaSDKFlightAvailabilityExecutor {
	public static void main(String[] args) throws ResponseException {

		Amadeus amadeus = Amadeus.builder("t0w4ASv032Pv8238GiRGr9w23Ubm1WGy", "6ZrSVc9GNnyyFeEG").build();

		String body = "{\"originDestinations\":[{\"id\":\"1\",\"originLocationCode\":\"ATH\",\"destinationLocationCode\":\"SKG\",\"departureDateTime\":{\"date\":\"2025-08-14\",\"time\":\"21:15:00\"}}],\"travelers\":[{\"id\":\"1\",\"travelerType\":\"ADULT\"}],\"sources\":[\"GDS\"]}";

		FlightAvailability[] flightAvailabilities = amadeus.shopping.availability.flightAvailabilities.post(body);

		if (flightAvailabilities[0].getResponse().getStatusCode() != 200) {
			System.out.println("Wrong status code: " + flightAvailabilities[0].getResponse().getStatusCode());
			System.exit(-1);
		}

		System.out.println(flightAvailabilities[0]);
	}
}
