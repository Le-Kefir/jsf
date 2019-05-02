package daos;

import entities.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Product addProduct(Product product) {
        entityManager.persist(product);

        return product;
    }

    public Product getProduct(int id) {
        return entityManager.find(Product.class, id);
    }

    public Product updateProduct(Product product) {
        entityManager.merge(product);

        return product;
    }


    public void deleteProduct(int id) {
        entityManager.remove(getProduct(id));
    }

    public List<Product> getProducts() {
        Query query = entityManager.createQuery("SELECT product FROM Product product", Product.class);

        return query.getResultList();
    }

}
