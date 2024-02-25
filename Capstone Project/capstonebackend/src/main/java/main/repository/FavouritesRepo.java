package main.repository;

import main.entities.Favourites;
import main.entities.FavouritesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FavouritesRepo extends the JpaRepository and has access to the default CRUD methods
 */
@Repository
public interface FavouritesRepo extends JpaRepository<Favourites, FavouritesId>{
}
