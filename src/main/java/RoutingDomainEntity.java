import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = false)
public class RoutingDomainEntity {
    int id;

    public RoutingDomainEntity(int id) {
        this.id = id;
    }
}