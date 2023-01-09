package org.acme;

import io.smallrye.mutiny.Uni;
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
    public Uni<Beer> getRandomBeer() {
        return beerService.getRandomBeer().map(beerDtos -> {
                    final BeerDto beerDto = beerDtos.stream().findFirst().orElseThrow();
                    return Beer.of(beerDto.getName(), beerDto.getTagline(), beerDto.getAbv());
                })
                .flatMap(beer -> beerDao.createBeer(beer));
    }
}