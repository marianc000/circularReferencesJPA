package sample.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import org.eclipse.persistence.config.CacheUsageIndirectionPolicy;
import org.eclipse.persistence.config.HintValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sample.entities.jpa.Country;

@Repository
public class CountryRepository {

    @Autowired
    EntityManager em;
    @Autowired
    EntityManagerFactory emf;

    public List<Country> getAll() {
        List<Country> countries = em.createQuery(
                "SELECT c FROM Country c left join c.authors a "
                + "left join a.posts p left join p.likes l"
                + " order by c.COUNTRY_NAME,a.AUTHOR_NAME,p.POST_NAME,l.AUTHOR_NAME")
                .setHint("eclipselink.left-join-fetch", "c.authors.posts.likes")
                .setHint("eclipselink.read-only", true)
                .getResultList();

        countries.stream().flatMap(c -> c.getAuthors().stream())
                .flatMap(a -> a.getPosts().stream()) // all posts
                .forEach(p -> p.removePostsInFans());

        return countries;
    }

}
