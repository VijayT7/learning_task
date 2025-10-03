package com.t7slution.databasecrudsqlquery.repository;


import com.t7slution.databasecrudsqlquery.model.Todo;
import com.t7slution.databasecrudsqlquery.model.TodoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Todo findFirstByTitle(String title);

    @Query("SELECT t FROM Todo t where t.title = ?1")
    List<Todo> getTodoByTitle(String title);


}
