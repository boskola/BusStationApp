package project.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import project.model.Line;

public interface LineService {
	
	Line findOne(Long id);
	List<Line> findAll();
	Page<Line> findAll(Pageable pageable);
	Line save(Line line);
	Line update(Line line);
	Line delete(Long id);
	
	Page<Line> find(String destination, Long operatorId, Double maxTicketPrice, int page);
	

}
