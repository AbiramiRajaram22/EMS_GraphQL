package com.example.EMSwithGraphQL.repository;

import com.example.EMSwithGraphQL.model.Project;
import com.example.EMSwithGraphQL.model.Skills;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

@GraphQlRepository
public interface SkillRepository extends Neo4jRepository<Skills, Long> {
   @Query("MATCH (p:Project) WHERE ID(p) = $projectId\n" +
            "MATCH (s:Skills)-[r]->(e:Employee) WHERE ID(e)=$employeeId \n" +
            "MATCH (p)-[:TECH_STACK]->(s)\n" +
            "RETURN COLLECT({elementId: ID(s), skillName: s.skillName, level:type(r)}) as skills")
    List<Skills> fetchSkillsByProject(@Param("employeeId") Long employeeId, @Param("projectId") Long projectId);

    @Query("MATCH (s:Skills) WHERE ID(s) = $elementId SET s.skillName = $skillName")
    Skills updateSkill(@Param("skillName") String skillName, @Param("elementId") Long elementId);

    @Query("MATCH (s:Skills) return COLLECT({elementId: ID(s), skillName: s.skillName}) as skills")
    List<Skills> findAll();
}