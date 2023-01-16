package project.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.model.Operator;
import project.service.OperatorService;
import project.support.OperatorDtoToOperator;
import project.support.OperatorToOperatorDto;
import project.web.dto.OperatorDTO;

@RestController
@RequestMapping(value = "/api/operators", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class OperatorController {
	
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private OperatorDtoToOperator toOperator;
	
	@Autowired
	private OperatorToOperatorDto toOperatorDto;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OperatorDTO> create(@Valid @RequestBody OperatorDTO operatorDTO){
		Operator operator = toOperator.convert(operatorDTO);
		Operator savedOperator = operatorService.save(operator);
		
		return new ResponseEntity<>(toOperatorDto.convert(savedOperator), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<OperatorDTO>> getAll(){
		List<Operator> operators = operatorService.findAll();
		
		return new ResponseEntity<>(toOperatorDto.convert(operators), HttpStatus.OK);
	}
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
