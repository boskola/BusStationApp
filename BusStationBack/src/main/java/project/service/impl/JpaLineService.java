package project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import project.model.Line;
import project.repository.LineRepository;
import project.service.LineService;

@Service
public class JpaLineService implements LineService {
	
	@Autowired
	private LineRepository lineRepository;
	
	@Override
	public Line findOne(Long id) {
		// TODO Auto-generated method stub
		return lineRepository.findOneById(id);
	}

	@Override
	public List<Line> findAll() {
		// TODO Auto-generated method stub
		return lineRepository.findAll();
	}

	@Override
	public Page<Line> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return lineRepository.findAll(pageable);
	}

	@Override
	public Line save(Line line) {
		// TODO Auto-generated method stub
		return lineRepository.save(line);
	}

	@Override
	public Line update(Line line) {
		// TODO Auto-generated method stub
		return lineRepository.save(line);
	}

	@Override
	public Line delete(Long id) {
		// TODO Auto-generated method stub
		Line line = findOne(id);
		if(line != null) {
			line.getOperator().getLines().remove(line);
			lineRepository.delete(line);
		}
		
		return null;
	}

	@Override
	public Page<Line> find(String destination, Long operatorId, Double maxTicketPrice, int page) {
		
		if(destination == null) {
			destination="";
		}
		
		if(maxTicketPrice == null) {
			maxTicketPrice = Double.MAX_VALUE;
		}
		
		if(operatorId == null) {
			return lineRepository.findByDestinationIgnoreCaseContainsAndTicketPriceLessThanEqual(destination, maxTicketPrice, PageRequest.of(page, 3));
		}
		
		return lineRepository.findByDestinationIgnoreCaseContainsAndOperatorIdAndTicketPriceLessThanEqual(destination, operatorId, maxTicketPrice, PageRequest.of(page, 3));
	}

}
