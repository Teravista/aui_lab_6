package proj;


import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proj.service.MeatProductService;
import proj.service.MeatTypeService;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Listener started automatically on Spring application context initialized. When using persistence storage application
 * instance should be initialized only during first run in order to init database with starting data. Good place to
 * create first default admin user.
 */
@Component
public class INIT implements InitializingBean {


    private final MeatTypeService meatTypeService;
    private final MeatProductService meatProductService;

    @Autowired
    public INIT(MeatTypeService meatTypeService,MeatProductService meatProductService)
    {
        this.meatTypeService=meatTypeService;
        this.meatProductService=meatProductService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        MeatType meatType1  = MeatType.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .name("Wedliny")
                .popularity(45)
                .meatProducts(new ArrayList<>())
                .build();
        MeatType meatType2 = MeatType.builder()
                .id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e"))
                .name("Drob")
                .popularity(50)
                .meatProducts(new ArrayList<>())
                .build();
        MeatType meatType3 = MeatType.builder()
                .id(UUID.fromString("ed6cfb2a-cad7-47dd-9b56-9d1e3c7a4197"))
                .name("Wieprzowe")
                .popularity(10)
                .meatProducts(new ArrayList<>())
                .build();

        meatTypeService.create(meatType1);
        meatTypeService.create(meatType2);
        meatTypeService.create(meatType3);
        MeatProduct meatProduct1 =  MeatProduct.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .name("Kiełbasa")
                .intensity(3)
                .build();
        MeatProduct meatProduct2 =  MeatProduct.builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .name("Szynka")
                .intensity(12)
                .build();
        MeatProduct meatProduct3 =  MeatProduct.builder()
                .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                .name("rolada_boczkowa")
                .intensity(8)
                .build();
        MeatProduct meatProduct4 =  MeatProduct.builder()
                .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0"))
                .name("kurczak")
                .intensity(141)
                .build();
        MeatProduct meatProduct5 =  MeatProduct.builder()
                .id(UUID.fromString("cc0b0577-bb6f-45b7-81d6-3db88e6ac19f"))
                .name("gęsina")
                .intensity(2)
                .build();
        MeatProduct meatProduct6 =  MeatProduct.builder()
                .id(UUID.fromString("f08ef7e3-7f2a-4378-b1fb-2922d730c70d"))
                .name("Boczek")
                .intensity(89)
                .build();

        meatType1.addMeatProduct(meatProduct1);
        meatType1.addMeatProduct(meatProduct2);
        meatType1.addMeatProduct(meatProduct3);
        meatType2.addMeatProduct(meatProduct4);
        meatType2.addMeatProduct(meatProduct5);
        meatType3.addMeatProduct(meatProduct6);


        meatProductService.create(meatProduct1);
        meatProductService.create(meatProduct2);
        meatProductService.create(meatProduct3);
        meatProductService.create(meatProduct4);
        meatProductService.create(meatProduct5);
        meatProductService.create(meatProduct6);
        System.out.println("starting type command");
        System.out.println("type \"help\" to print out avaliable comands");
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

