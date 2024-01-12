package proj;import lombok.Builder;
import lombok.Getter;
@Getter
public class MeatProductDto {
    String name;
    public MeatProductDto(MeatProduct meatProduct){this.name=meatProduct.getName();}
}
