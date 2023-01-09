package org.acme;

import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/beer")
public class BeerResource {

    @RestClient
    BeerService beerService;

    @Inject
    BeerDao beerDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Beer getRandomBeer() {
        final BeerDto beerDto = beerService.getRandomBeer().stream().findFirst().orElseThrow();
        final Beer beer = Beer.of(beerDto.getName(), beerDto.getTagline(), beerDto.getAbv());
        beerDao.createBeer(beer);
        return beer;
    }
}