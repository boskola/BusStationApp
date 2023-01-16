package project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.model.Line;

@Repository
public interface LineRepository extends JpaRepository<Line, Long>{
	
	Line findOneById(Long id);
	
	Page<Line> findByDestinationIgnoreCaseContainsAndOperatorIdAndTicketPriceLessThanEqual(String destination, Long operatorId, Double maxTicketPrice, Pageable pageable);
	
	Page<Line> findByDestinationIgnoreCaseContainsAndTicketPriceLessThanEqual(String destination, Double maxTicketPrice, Pageable pageable);
	
	Page<Line> findByDestinationIgnoreCaseContains(String destination, Pageable pageable);
	
}
