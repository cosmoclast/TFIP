package main.repository;

import main.entities.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * LocationsRepo extends the JpaRepository and has access to the default CRUD methods
 */
@Repository
public interface LocationsRepo extends JpaRepository<Locations, String>{
}
