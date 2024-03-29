package com.example.kingcar_be.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Getter
@Setter
@Entity
public class CarImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carImageId;

    @NotNull
    @Column(name = "brand_name")
    private String brandName;

    @NotNull
    @Column(name = "brand_model")
    private String brandModel;

    @NotNull
    @Column(name = "model_image")
    private String modelImage;
}
