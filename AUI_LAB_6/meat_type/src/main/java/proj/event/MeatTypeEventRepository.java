package proj.event;
import proj.MeatType;

import java.util.UUID;
public interface MeatTypeEventRepository {
    void delete(UUID id);
    public void create(MeatType meatType);
}
