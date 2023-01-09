package org.fdhl;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {
    public List<Movie> findByCountry(String country) {
        return list("SELECT m FROM Movie m WHERE m.country = ?1 ORDER BY m.id DESC", country);
    }

    public List<Movie> merge(Movie movie) {
        return Collections.singletonList(getEntityManager().merge(movie));
    }
}
