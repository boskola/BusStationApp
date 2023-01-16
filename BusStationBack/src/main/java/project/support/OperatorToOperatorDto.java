package project.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.model.Operator;
import project.web.dto.OperatorDTO;

@Component
public class OperatorToOperatorDto implements Converter<Operator, OperatorDTO>{

	@Override
	public OperatorDTO convert(Operator operator) {
		
		OperatorDTO dto = new OperatorDTO();
		
		dto.setId(operator.getId());
		dto.setName(operator.getName());
		dto.setAdress(operator.getAdress());
		dto.setVAT(operator.getVat());
		
		return dto;
	}
	
	public List<OperatorDTO> convert(List<Operator> operators){
		List<OperatorDTO> operatortsDto = new ArrayList<>();
		
		for(Operator operator: operators) {
			operatortsDto.add(convert(operator));
		}
		
		return operatortsDto;
	}

}
