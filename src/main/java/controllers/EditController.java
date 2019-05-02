package controllers;

import daos.ProductDAO;
import entities.Product;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class EditController implements Serializable {

    private Product product;

    @EJB
    ProductDAO productDAO;

    public EditController() {
        product = new Product();
    }

    public String update(int id) {
        product = productDAO.getProduct(id);
        return "adminView/edit";
    }

    public String save() {
        productDAO.updateProduct(product);
        return "/index";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
