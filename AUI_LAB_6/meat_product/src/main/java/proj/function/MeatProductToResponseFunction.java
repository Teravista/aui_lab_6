package proj.function;

import org.springframework.stereotype.Component;
import proj.MeatProduct;
import proj.dto.GetMeatProductResponse;

import java.util.function.Function;
@Component

public class MeatProductToResponseFunction implements Function<MeatProduct, GetMeatProductResponse> {
    @Override
    public GetMeatProductResponse apply(MeatProduct entity)
    {
        return GetMeatProductResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .intensity(entity.getIntensity())
                .meatType(GetMeatProductResponse.MeatType.builder()
                        .id(entity.getMeatType().getId())
                        .name(entity.getMeatType().getName())
                        .build())
                .build();
    }
}
