package gn.diallotelly.projet.web.ecole.primaire.repository;

import gn.diallotelly.projet.web.ecole.primaire.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
