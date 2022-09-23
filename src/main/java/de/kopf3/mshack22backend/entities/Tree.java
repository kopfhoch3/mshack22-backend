package de.kopf3.mshack22backend.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TREES")
@DiscriminatorValue("tree")
public class Tree extends ActivityPoint {
    @Id
    private Long id;
    private String strKey;
    private String treeType;
}
