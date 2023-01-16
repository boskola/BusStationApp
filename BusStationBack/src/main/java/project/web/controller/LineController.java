package project.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.model.Line;
import project.service.LineService;
import project.support.LineDtoToLine;
import project.support.LineToLineDto;
import project.web.dto.LineDTO;

@RestController
@RequestMapping(value = "/api/lines", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LineController {
	
	@Autowired
	private LineService lineService;
	
	@Autowired
	private LineDtoToLine toLine;
	
	@Autowired
	private LineToLineDto toLineDto;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LineDTO> create(@Valid @RequestBody LineDTO lineDTO){
		Line line = toLine.convert(lineDTO);
		
		Line savedLine = lineService.save(line);
		
		return new ResponseEntity<>(toLineDto.convert(savedLine), HttpStatus.CREATED);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LineDTO> update(@PathVariable Long id, @Valid @RequestBody LineDTO lineDTO){
		
		if(!id.equals(lineDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Line line = toLine.convert(lineDTO);
		System.out.println("Line: " + line);
		Line savedLine = lineService.update(line);
		
		return new ResponseEntity<>(toLineDto.convert(savedLine), HttpStatus.OK);
	}
	
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<LineDTO> getOne(@PathVariable Long id){
		Line line = lineService.findOne(id);
		
		if(line != null) {
			return new ResponseEntity<>(toLineDto.convert(line), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Line deletedLine = lineService.delete(id);
		
		if(deletedLine != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<LineDTO>> getAll(
			 @RequestParam(required=false) String destination,
			 @RequestParam(required = false) Long operatorId,
			 @RequestParam(required = false) Double maxTicketPrice,
			 @RequestParam(value = "pageNo", defaultValue = "0") int pageNo
			){
		
		Page<Line> page = lineService.find(destination, operatorId, maxTicketPrice, pageNo);
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
	    System.out.println("HEDER: "+headers);
	    System.out.println(Integer.toString(page.getTotalPages()));
		
	    //List<Line> lines = lineService.findAll();
	    
		return new ResponseEntity<>(toLineDto.convert(page.getContent()), headers, HttpStatus.OK);
	}
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
