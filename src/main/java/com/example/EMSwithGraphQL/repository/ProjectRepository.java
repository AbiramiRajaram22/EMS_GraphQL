package com.example.EMSwithGraphQL.repository;

import com.example.EMSwithGraphQL.model.Project;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

@GraphQlRepository
public interface ProjectRepository extends Neo4jRepository<Project, Long> {
    @Query("MATCH (p:Project)-[r]->(e:Employee) WHERE ID(e)= $elementId AND type(r) = $clientName\n" +
        "RETURN p")
    List<Project> fetchEmployeeProjects(@Param("elementId") Long elementId, @Param("clientName") String clientName);
}