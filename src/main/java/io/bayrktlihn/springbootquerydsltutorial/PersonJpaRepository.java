package io.bayrktlihn.springbootquerydsltutorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PersonJpaRepository extends JpaRepository<Person, Long>, QuerydslPredicateExecutor<Person> {
}
