package proj;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;
import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name="meat_products")
public class MeatProduct implements Comparable<MeatProduct>, Serializable {

    @Id
    private UUID id;

    @Column(unique=true)
    String name;

    int intensity;

    @ManyToOne
    @JoinColumn(name="meat_type")
    MeatType meatType;
    /*public MeatProduct(String name,int intensity,MeatType meatType)
    {
        this.name=name;
        this.intensity=intensity;
        this.meatType=meatType;
    }*/
    @Override
    public int hashCode() {
        return (Objects.hash(name)+Objects.hash(intensity));
    }
    @Override
    public String toString() {
        return this.name+" intensywnosc: "+this.intensity;
    }

    @Override
    public int compareTo(MeatProduct meatProduct) {
        return this.name.compareTo(meatProduct.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        MeatProduct other = (MeatProduct) obj;
        return this.intensity == other.intensity && Objects.equals(name, other.name);
    }
}
