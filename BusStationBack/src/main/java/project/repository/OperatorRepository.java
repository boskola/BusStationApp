package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long>{
	
	Operator findOneById(Long id);
	Operator findOneByName(String name);

}
