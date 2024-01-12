package proj.dto;

import lombok.*;
import proj.MeatProduct;
import proj.MeatType;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMeatTypesResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class MeatType{
        private UUID id;
        private  String name;
    }
    @Singular
    private List<MeatType> meatTypes;
}
