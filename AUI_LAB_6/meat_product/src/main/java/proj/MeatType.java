package proj;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name="meat_type")
@ToString(callSuper = true)
public class MeatType implements Comparable<MeatType>, Serializable {

    @Id
    private UUID id;

    @Column(unique=true)
    String name;

    int popularity;

    @OneToMany(mappedBy = "meatType", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    List<MeatProduct> meatProducts =new ArrayList<>();

    public MeatType(String name,int popularity,List<MeatProduct> meatProducts){
        this.name=name;
        this.popularity=popularity;
        this.meatProducts=new ArrayList<>();

    }
    @Override
    public int hashCode() {
        return (Objects.hash(name)+Objects.hash(popularity));
    }


    @Override
    public int compareTo(MeatType meatType) {
        return this.name.compareTo(meatType.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        MeatType other = (MeatType) obj;
        return this.popularity == other.popularity && Objects.equals(this.name, other.name);
    }

    public void addMeatProduct(MeatProduct meatProduct)
    {
        meatProducts.add(meatProduct);
        meatProduct.setMeatType(this);
    }

}