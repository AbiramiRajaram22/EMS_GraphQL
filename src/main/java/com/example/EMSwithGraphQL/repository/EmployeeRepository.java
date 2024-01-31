package com.example.EMSwithGraphQL.repository;

import com.example.EMSwithGraphQL.model.Employee;
import com.example.EMSwithGraphQL.model.Project;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.List;

@GraphQlRepository
public interface EmployeeRepository extends Neo4jRepository<Employee, Long> {
    @Query("MATCH (e:Employee {empName:$name}) RETURN e")
    Employee fetchEmployee(@Param("name") String name);
}