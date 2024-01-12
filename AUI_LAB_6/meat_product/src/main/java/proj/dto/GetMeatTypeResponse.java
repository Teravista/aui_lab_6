package proj.dto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import proj.MeatType;

import java.util.List;
import java.util.Map;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMeatTypeResponse {
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
    private UUID id;
    private String name;
    private int popularity;

    @Singular("meatType")
    private List<MeatProduct> meatProducts;
}
