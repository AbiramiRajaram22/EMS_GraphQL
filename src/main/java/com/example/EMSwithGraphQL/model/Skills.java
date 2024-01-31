package com.example.EMSwithGraphQL.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node
@Data
@NoArgsConstructor
public class Skills {
    @Id
    public Long elementId;
    public String skillName;
    public String level;
}