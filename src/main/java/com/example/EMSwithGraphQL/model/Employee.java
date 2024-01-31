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
public class Employee {
    @Id @GeneratedValue
    public Long elementId;
    public String empName;
    public String designation;
    @Relationship(type = "MHE", direction = Relationship.Direction.INCOMING)
    public List<Project> mheProjects;
    @Relationship(type = "TNF", direction = Relationship.Direction.INCOMING)
    public List<Project> tnfProjects;
}