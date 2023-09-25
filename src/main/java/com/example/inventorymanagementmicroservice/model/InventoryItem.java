package com.example.inventorymanagementmicroservice.model;

import com.example.inventorymanagementmicroservice.model.enums.Condition;
import com.example.inventorymanagementmicroservice.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventory_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long sku;
    private Long productId;
    private String location;
    private Long quantity;
    private Long reservedQuantity;
    private Long reorderPoint;
    private Long reorderQuantity;
    private Double cost;
    private LocalDateTime lastUpdated;
    private Date purchaseDate;
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private String BatchNumber;

    @Enumerated(EnumType.STRING)
    private Condition condition;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection
    private List<String> locationHistory;

//   	Next: serial numbers, shelf locations, warranty information, etc.
}
