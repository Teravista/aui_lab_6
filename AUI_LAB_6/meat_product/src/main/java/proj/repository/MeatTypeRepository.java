package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.MeatType;

import java.util.UUID;
@Repository
public interface MeatTypeRepository extends JpaRepository<MeatType, UUID> {
}
