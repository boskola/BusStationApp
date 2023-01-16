package project.service;

import java.util.List;

import project.model.Operator;

public interface OperatorService {
	
	Operator findOne(Long id);
	Operator save(Operator operator);
	Operator findOneByName(String name);
	List<Operator> findAll();

}
