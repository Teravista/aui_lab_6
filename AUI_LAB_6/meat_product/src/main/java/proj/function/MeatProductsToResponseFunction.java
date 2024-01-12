package proj.function;

import org.springframework.stereotype.Component;
import proj.MeatProduct;
import proj.dto.GetMeatProductsResponse;

import java.util.List;
import java.util.function.Function;
@Component
public class MeatProductsToResponseFunction implements Function<List<MeatProduct>, GetMeatProductsResponse> {
    @Override
    public GetMeatProductsResponse apply(List<MeatProduct> entities)
    {
        return GetMeatProductsResponse.builder()
                .meatProducts(entities.stream()
                        .map(meatProduct->GetMeatProductsResponse.MeatProduct.builder()
                                .id(meatProduct.getId())
                                .name(meatProduct.getName())
                                .build())
                        .toList())
                .build();
    }

}
