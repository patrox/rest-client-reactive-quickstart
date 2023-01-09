package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class BeerDao {
    @Inject
    EntityManager em;

    @Transactional
    public Beer createBeer(Beer beer) {
        em.persist(beer);
        return beer;
    }
}