package project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.Operator;
import project.repository.OperatorRepository;
import project.service.OperatorService;

@Service
public class JpaOperatorService implements OperatorService {
	
	@Autowired
	private OperatorRepository operatorRepository;
	
	@Override
	public Operator findOne(Long id) {
		// TODO Auto-generated method stub
		return operatorRepository.findOneById(id);
	}

	@Override
	public Operator save(Operator operator) {
		// TODO Auto-generated method stub
		return operatorRepository.save(operator);
	}

	@Override
	public Operator findOneByName(String name) {
		// TODO Auto-generated method stub
		return operatorRepository.findOneByName(name);
	}

	@Override
	public List<Operator> findAll() {
		// TODO Auto-generated method stub
		return operatorRepository.findAll();
	}

}
