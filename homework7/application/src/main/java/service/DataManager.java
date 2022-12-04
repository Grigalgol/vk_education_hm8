package service;

import com.google.inject.Inject;
import dao.CompanyDAO;
import dao.ProductDAO;
import entity.Company;
import entity.Product;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DataManager {
    @Inject
    private ProductDAO productDAO;
    @Inject
    private CompanyDAO companyDAO;

    public void saveProduct(@NotNull String name, @NotNull String companyName, @NotNull Integer count) {
        Company company;
        try {
            company = companyDAO.getCompanyByName(companyName);
        } catch (IllegalStateException e) {
            companyDAO.saveCompany(new Company(0, companyName));
            company = companyDAO.getCompanyByName(companyName);
        }
        productDAO.saveProduct(new Product(0, name, company.getId(), count));
    }

    public @NotNull List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public boolean deleteProductByName(String name) {
        return productDAO.deleteProduct(name);
    }

    public List<Product> getProductByCompany(String name) {
        return productDAO.getAllProductsByCompany(name);
    }
}
