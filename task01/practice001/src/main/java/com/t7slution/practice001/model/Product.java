package com.t7slution.practice001.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data
public class Product {

    @Id
    private int id;
    private String name;
    private int price;


}
