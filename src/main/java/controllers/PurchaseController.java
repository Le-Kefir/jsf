package controllers;

import daos.CustomerDAO;
import entities.Customer;
import entities.Product;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class PurchaseController implements Serializable {

    private Product product;
    private Customer customer;

    @EJB
    private CustomerDAO customerDAO;

    public PurchaseController() {
        customer = new Customer();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String buy(Product product) {
        this.product = product;
        customer.setProduct(product);
        return "buy";
    }

    public String createCustomer() {
        customerDAO.save(customer);
        return "complete";
    }
}
