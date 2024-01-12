package proj;


import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proj.service.MeatTypeService;

import java.io.InputStream;
import java.util.UUID;

/**
 * Listener started automatically on Spring application context initialized. When using persistence storage application
 * instance should be initialized only during first run in order to init database with starting data. Good place to
 * create first default admin user.
 */
@Component
public class INIT implements InitializingBean {


    private final MeatTypeService meatTypeService;

    @Autowired
    public INIT(MeatTypeService meatTypeService)
    {
        this.meatTypeService=meatTypeService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        MeatType meatType1  = MeatType.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .name("Wedliny")
                .popularity(45)
                .build();
        MeatType meatType2 = MeatType.builder()
                .id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e"))
                .name("Drob")
                .popularity(50)
                .build();
        MeatType meatType3 = MeatType.builder()
                .id(UUID.fromString("ed6cfb2a-cad7-47dd-9b56-9d1e3c7a4197"))
                .name("Wieprzowe")
                .popularity(10)
                .build();

        meatTypeService.create(meatType1,false);
        meatTypeService.create(meatType2,false);
        meatTypeService.create(meatType3,false);

    }

    /**
     * @param name name of the desired resource
     * @return array of bytes read from the resource
     */
    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            return is.readAllBytes();
        }
    }

}

