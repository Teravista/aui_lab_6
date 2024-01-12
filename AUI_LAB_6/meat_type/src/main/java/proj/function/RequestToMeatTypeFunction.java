package proj.function;

import org.springframework.stereotype.Component;
import proj.MeatType;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToMeatTypeFunction implements BiFunction<UUID,PutMeatTypeRequest, MeatType> {
    @Override
    public MeatType apply(UUID id,PutMeatTypeRequest request)
    {
        return MeatType.builder()
                .id(id)
                .name(request.getName())
                .popularity(request.getPopularity())
                .build();
    }
}
