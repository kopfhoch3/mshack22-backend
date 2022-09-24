package de.kopf3.mshack22backend.api.to.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import de.kopf3.mshack22backend.api.to.TreeTo;
import de.kopf3.mshack22backend.persistence.document.TreePoint;

@Component
public class TreeToMapper {
    public TreeTo from(final TreePoint point) {
        return new TreeTo(
            point.getId().toHexString(),
            point.getTreeFamily(),
            List.copyOf(point.getLocation().getCoordinates())
        );
    }
}
