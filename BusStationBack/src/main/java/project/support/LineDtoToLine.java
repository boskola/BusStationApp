package project.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.model.Line;
import project.service.LineService;
import project.service.OperatorService;
import project.web.dto.LineDTO;

@Component
public class LineDtoToLine implements Converter<LineDTO, Line>{
	
	@Autowired
	private LineService lineService;
	
	@Autowired
	private OperatorService operatorService;
	
	@Override
	public Line convert(LineDTO dto) {
		
		Line line;
		
		if(dto.getId() == null) {
			line = new Line();
		}else {
			line = lineService.findOne(dto.getId());
		}
		
		if(line != null) {
			line.setSeatsNumber(dto.getSeatsNumber());
			line.setDepartureTime(dto.getDepartureTime());
			line.setDestination(dto.getDestination());
			line.setOperator(operatorService.findOne(dto.getId()));
			//line.setOperator(operatorService.findOneByName(dto.getOperatorName()));
		}
		
		return line;
	}

}
