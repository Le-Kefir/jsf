package controllers;

import daos.ProductDAO;
import entities.Product;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class ProductController {

    private Product product;

    @EJB
    private ProductDAO productDAO;

    public List<Product> getProducts() {
        return productDAO.getProducts();
    }
}
