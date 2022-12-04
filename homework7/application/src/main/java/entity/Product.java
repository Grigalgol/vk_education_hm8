package entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @JsonProperty("id")
    private @NotNull Integer id;
    @JsonProperty("name")
    private @NotNull String name;
    @JsonProperty("company_id")
    private @NotNull Integer companyId;
    @JsonProperty("count")
    private @NotNull Integer count;

    @JsonCreator
    public Product(@JsonProperty("id") int id,
                   @JsonProperty("name") @NotNull String name,
                   @JsonProperty("company_id") @NotNull Integer companyId,
                   @JsonProperty("count") @NotNull Integer count) {
        this.id = id;
        this.name = name;
    }
}
