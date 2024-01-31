package com.example.EMSwithGraphQL.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
@Data
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    public Long elementId;
    public String name;
    @Relationship(type = "TECH_STACK", direction = Relationship.Direction.OUTGOING)
    public List<Skills> skills;
}