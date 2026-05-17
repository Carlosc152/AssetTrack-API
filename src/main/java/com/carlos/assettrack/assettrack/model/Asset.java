package com.carlos.assettrack.assettrack.model;


import com.carlos.assettrack.assettrack.model.enums.AssetStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Validación para el nombre
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    // Relación con Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //Validación para el serial
    @NotBlank(message = "El serial es obligatorio")
    private String serialNumber;

    // Usamos el Enum y le decimos a JPA que lo guarde como texto ("AVAILABLE", etc.)
    @NotNull(message = "El status es obligatorio")
    @Enumerated(EnumType.STRING)
    private AssetStatus status;
    
    //Validación para el valor de compra
    @NotNull(message = "El valor de compra es obligatorio")
    @Positive(message = "El valor debe ser mayor a 0")
    private Double purchaseValue;

}
