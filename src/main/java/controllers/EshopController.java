package controllers;

import daos.ProductDAO;
import entities.Product;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class EshopController implements Serializable {

    private Product product;

    @EJB
    ProductDAO productDAO;

    public EshopController() {
        product = new Product();
    }

    public void delete(int id) {
        productDAO.deleteProduct(id);
    }


    public String add() {
        productDAO.addProduct(product);
        return "/index";
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
