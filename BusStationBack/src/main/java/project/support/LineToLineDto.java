package project.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.model.Line;
import project.web.dto.LineDTO;

@Component
public class LineToLineDto implements Converter<Line, LineDTO>{

	@Override
	public LineDTO convert(Line line) {
		
		LineDTO dto = new LineDTO();
		
		dto.setId(line.getId());
		dto.setSeatsNumber(line.getSeatsNumber());
		dto.setTicketPrice(line.getTicketPrice());
		dto.setDepartureTime(line.getDepartureTime());
		dto.setDestination(line.getDestination());
		dto.setOperatorId(line.getOperator().getId());
		dto.setOperatorName(line.getOperator().getName());
		
		return dto;
	}
	
	public List<LineDTO> convert(List<Line> lines){
		
		List<LineDTO> linesDto = new ArrayList<>();
		
		for(Line line: lines) {
			linesDto.add(convert(line));
		}
		
		return linesDto;
	}

}
