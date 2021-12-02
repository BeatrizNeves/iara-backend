package iara.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.AlternativeEntity;

public interface AlternativeRepository extends JpaRepository<AlternativeEntity, Long> {

	List<AlternativeEntity> findAll(Specification<AlternativeEntity> filter);
}
