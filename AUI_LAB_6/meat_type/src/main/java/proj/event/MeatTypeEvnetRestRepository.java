package proj.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import proj.MeatType;
import proj.dto.PutMeatTypeResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Repository
public class MeatTypeEvnetRestRepository implements MeatTypeEventRepository{

    private final RestTemplate restTemplate;

    @Autowired
    public MeatTypeEvnetRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }
    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/meatTypes/{id}", id);
    }

    @Override
    public void create(MeatType meatType) {

        PutMeatTypeResponse meatTypeToSend  = PutMeatTypeResponse.builder()
                //.id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
               .name(meatType.getName())
               .popularity(meatType.getPopularity())
               .build();

        restTemplate.put("/api/meatTypes/"+meatType.getId(), meatTypeToSend, Void.class);
       // HttpEntity<String> entity = new HttpEntity<String>(meatType1, headers);
       // restTemplate.put("/api/meatTypes", entity);
        //restTemplate.put("/api/meatTypes",meatType);
    }
}
