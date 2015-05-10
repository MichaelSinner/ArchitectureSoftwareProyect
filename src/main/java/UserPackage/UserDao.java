package UserPackage;

import java.util.List;

/**
 *
 * @author Sinner
 */
public interface UserDao {
    
    /**
     * Creates a new product. 
     * @param User
     * @return 
     */
    
    User create(User user);

    /**
     * Updates an existing product. Product id can't be modified.
     * @param User
     * @return 
     */
    void update(int idUser);

    /**
     * Deletes an existing product
     * @param product 
     */
    void delete(int idUser);

    /**
     * Find a product by id
     * @param idUser
     * @return 
     */
    User findById(Integer idUser);

    /**
     * Returns all the products in the database
     * @return 
     */
    List<User> findAll();
}
