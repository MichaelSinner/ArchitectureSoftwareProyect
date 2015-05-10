/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPackage;

import UserPackage.User;
import java.util.List;

/**
 *
 * @author Sinner
 */
public interface AdministratorDao {
    
    /**
     * Creates a new product. 
     * @param Administrator
     * @return 
     */
    
    Administrator create(Administrator Admin);

    /**
     * Updates an existing product. Product id can't be modified.
     * @param idAdmin
     * @return 
     */
    void update(int idAdmin);

    /**
     * Deletes an existing product
     * @param Administrator 
     */
    void delete(int idAdmin);

    /**
     * Find a product by id
     * @param idAdmin
     * @return 
     */
    Administrator findById(int idAdmin);

    /**
     * Returns all the products in the database
     * @return 
     */
    
}
