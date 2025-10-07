package com.t7slution.ecomproject.services;

import com.t7slution.ecomproject.model.Product;
import com.t7slution.ecomproject.repo.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {


    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();

    }

    public Product getProductById(Integer id) {
        return productRepo.findById(id).orElse(null);


    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {

        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());


        return productRepo.save(product);

    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Product> searchProduct(String keyword) {
        return productRepo.searchProducts(keyword);

    }
}
