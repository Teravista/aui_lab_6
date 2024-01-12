package proj.function;

import org.springframework.stereotype.Component;
import proj.MeatType;
import proj.dto.GetMeatTypeResponse;

import java.util.function.Function;

@Component
public class MeatTypeToResponseFunction implements Function<MeatType, GetMeatTypeResponse> {
    @Override
    public GetMeatTypeResponse apply(MeatType entity) {
        return GetMeatTypeResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .popularity(entity.getPopularity())
                .build();
    }
}
