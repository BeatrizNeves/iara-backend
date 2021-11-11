package iara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.ExampleEntity;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {

}
