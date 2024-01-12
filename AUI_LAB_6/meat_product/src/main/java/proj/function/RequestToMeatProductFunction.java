package proj.function;

import org.springframework.stereotype.Component;
import proj.MeatProduct;
import proj.MeatType;
import proj.dto.GetMeatProductsResponse;

import java.util.UUID;
import java.util.function.BiFunction;
@Component
public class RequestToMeatProductFunction implements BiFunction<UUID,PutMeatProductRequest, MeatProduct> {

    @Override
    public MeatProduct apply(UUID id,PutMeatProductRequest request)
    {
        return MeatProduct.builder()
                .id(id)
                .name(request.getName())
                .intensity(request.getIntensity())
                .meatType(MeatType.builder()
                        .id(request.getMeatType())
                        .build())
                .build();
    }
}
