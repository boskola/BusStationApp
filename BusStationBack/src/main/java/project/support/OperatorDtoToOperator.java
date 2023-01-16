package project.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.model.Operator;
import project.service.OperatorService;
import project.web.dto.OperatorDTO;

@Component
public class OperatorDtoToOperator implements Converter<OperatorDTO, Operator>{
	
	@Autowired
	private OperatorService operatorService;
	
	@Override
	public Operator convert(OperatorDTO dto) {
		
		Operator operator;
		
		if(dto.getId() == null) {
			operator = new Operator();
		}else {
			operator = operatorService.findOne(dto.getId());
		}
		
		if(operator != null) {
			operator.setName(dto.getName());
			operator.setAdress(dto.getAdress());
			operator.setVat(dto.getVAT());
		}
		
		return operator;
	}

}
