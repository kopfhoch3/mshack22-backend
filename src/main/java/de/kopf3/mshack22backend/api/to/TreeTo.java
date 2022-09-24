package de.kopf3.mshack22backend.api.to;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TreeTo {
    private String id;
    private String treeFamily;
    private List<Double> coordinates;
}
