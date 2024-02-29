package com.example.EMSwithGraphQL.model;

import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
//@Data
@NoArgsConstructor
public class Employee {
    @Id @GeneratedValue
    public Long elementId;
    public String empId;
    public  String empName;
    public String dateOfHire;
    public String mailId;
    public Double prevExp;
    public Double triconExp;
    public Double totalExp;
    public String billingStatus;
    public String remarks;
    public String leaderPipeline;
    public String businessAccumen;
    public String coachable;
}