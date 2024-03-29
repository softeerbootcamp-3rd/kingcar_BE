package com.example.kingcar_be.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Setter
@Getter
public class BrandImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_image_id")
    private long brandImageId;

    @NotNull
    @Column(name = "brand_name")
    private String brandName;

    @NotNull
    @Column(name = "brand_logo")
    private String brandLogo;
}
