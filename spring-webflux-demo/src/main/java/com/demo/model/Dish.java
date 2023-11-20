package com.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@AllArgsConstructor //constructor con parametros
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "dishes")
public class Dish {
    @Id
    @EqualsAndHashCode.Include // para que las comparaciones de objetos lo hagan a traves de este id
    private String id;
    @Field //(name ="nameDish")  //no es obligatorio poner esta anotacion , salvo tenga un nombre diferente en la bd
    private String name;
    @Field
    private Double price;
    @Field
    private Boolean status;
}
