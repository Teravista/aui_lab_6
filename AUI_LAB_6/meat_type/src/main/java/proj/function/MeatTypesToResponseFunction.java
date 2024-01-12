package proj.function;

import org.springframework.stereotype.Component;
import proj.MeatType;
import proj.dto.GetMeatTypesResponse;

import java.util.List;
import java.util.function.Function;
@Component
public class MeatTypesToResponseFunction implements Function<List<MeatType>, GetMeatTypesResponse> {
    @Override
    public GetMeatTypesResponse apply(List<MeatType> entities)
    {
        return GetMeatTypesResponse.builder()
                .meatTypes(entities.stream()
                        .map(meatType->GetMeatTypesResponse.MeatType.builder()
                                .id(meatType.getId())
                                .name(meatType.getName())
                                .build())
                        .toList())
                .build();
    }

}
