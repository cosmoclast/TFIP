package main.entities;

import jakarta.persistence.*;

/**
 * Favourites entity for the favourites table in the database. It has a composite key, FavouritesId
 */
@Entity
@Table(name="favourites")
public class Favourites {
    /**
     * Composite key for the Favourites entity
     */
    @EmbeddedId
    private FavouritesId favouritesId;

    public Favourites() { };
    public Favourites(FavouritesId favouritesId) {
        super();
        this.favouritesId = favouritesId;
    }

    public FavouritesId getFavouritesId() { return favouritesId; }
    public void setFavouritesId(FavouritesId favouritesId) { this.favouritesId = favouritesId; }
}
