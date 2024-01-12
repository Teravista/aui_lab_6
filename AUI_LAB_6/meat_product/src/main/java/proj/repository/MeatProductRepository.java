package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.MeatProduct;
import proj.MeatType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MeatProductRepository extends JpaRepository<MeatProduct, UUID> {


    Optional<MeatProduct> findByIdAndMeatType(UUID id, MeatType meatType);

    List<MeatProduct> findAllByMeatType(MeatType meatType);
}
