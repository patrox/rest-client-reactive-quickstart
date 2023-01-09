package org.acme;

import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BeerDao {
    @Inject
    Mutiny.SessionFactory sf;

    public Uni<Beer> createBeer(Beer beer) {
        return sf.withTransaction(session ->
                session.persist(beer)
                        .replaceWith(beer));
    }
}