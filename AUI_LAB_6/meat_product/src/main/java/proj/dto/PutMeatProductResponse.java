package proj.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import proj.MeatType;

import java.util.UUID;

public class PutMeatProductResponse {
    String name;

    int intensity;

    private UUID meatType;
}
