package org.acme;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v2")
@RegisterRestClient
public interface BeerService {

    @GET
    @Path("/beers/random")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<BeerDto>> getRandomBeer();
}