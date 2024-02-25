package main.repository;

import main.entities.Defects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DefectsRepo extends the JpaRepository and has access to the default CRUD methods
 */
@Repository
public interface DefectsRepo extends JpaRepository<Defects, Integer>{
}
