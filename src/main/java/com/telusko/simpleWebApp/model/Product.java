package com.telusko.simpleWebApp.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    int prodId;
    String prodName;
    int price;
}
