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
public class Company {
    @JsonProperty("id")
    private @NotNull Integer id;
    @JsonProperty("name")
    private @NotNull String name;

    @JsonCreator
    public Company(@JsonProperty("id") int id, @JsonProperty("name") @NotNull String name) {
        this.id = id;
        this.name = name;
    }
}
