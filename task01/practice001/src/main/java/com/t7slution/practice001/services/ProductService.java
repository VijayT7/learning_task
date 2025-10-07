package com.t7slution.practice001.services;


import com.t7slution.practice001.model.Product;
import com.t7slution.practice001.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int productId) {
        return productRepository.findById(productId)
                .orElse(new Product());
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(int productId){
        productRepository.deleteById(productId);
    }


//    // before database connection
//    List<Product> productList=new ArrayList<>( Arrays
//            .asList(new Product(1, "iphone", 50000),
//                    new Product(2, "laptop", 60000),
//                    new Product(3, "computer", 30000)));
//
//    public List<Product> getProducts(){
//        return productList;
//    }
//    public Product getProductById(int productId) {
//        return productList.stream()
//                .filter(p -> p.getId() == productId)
//                .findFirst().orElse(new Product(0,"No item", 0));
//    }
//    public void addProduct(Product product){
//        productList.add(product);
//    }
//
//    public void updateProduct(Product product) {
//        int index =0;
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getId() == product.getId()) {
//                index = i;
//                break;
//            }
//        }
//        productList.set(index, product);
//
//
//
// //        for (Product p :productList){
// //            if (p.getId() == product.getId()) {
// //                            p.setPrice(product.getPrice());
// //                            p.setName(product.getName());
// //                        }
// //                        break;
// //        };
//    }
//
//    public void deleteProduct(int productId) {
//        int index =0;
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getId() == productId) {
//                index = i;
//                break;
//            }
//        }
//        productList.remove(index);
//    }




}
