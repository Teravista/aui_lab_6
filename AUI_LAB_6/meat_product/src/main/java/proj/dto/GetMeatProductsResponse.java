package proj.dto;

import lombok.*;
import proj.MeatProduct;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMeatProductsResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class MeatProduct{
        private UUID id;
        private  String name;
    }
    @Singular
    private List<MeatProduct> meatProducts;
}
