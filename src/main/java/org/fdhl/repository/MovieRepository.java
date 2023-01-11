package org.fdhl.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.fdhl.model.Movie;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {
    public List<Movie> findByCountry(String country) {
        return list("SELECT m FROM Movie m WHERE m.country = ?1 ORDER BY m.id DESC", country);
    }


    public Optional<Movie> findByIdOptional(UUID id) {
        return find("id", id).firstResultOptional();
    }

    public long deleteById(UUID id) {
        return delete("id", id);
    }

    public List<Movie> merge(Movie movie) {
        return Collections.singletonList(getEntityManager().merge(movie));
    }
}
