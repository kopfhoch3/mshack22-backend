package de.kopf3.mshack22backend.api.wsto;

import lombok.Data;
import org.springframework.data.geo.Point;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PointFilter {
    @NotNull
    private Double x;
    @NotNull
    private Double y;
    @NotNull
    private int radius;
    @NotNull
    private List<String> types;

}
