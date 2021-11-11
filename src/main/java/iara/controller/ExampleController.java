package iara.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iara.converter.ExampleConverter;
import iara.model.ExampleEntity;
import iara.model.ExampleRequest;
import iara.service.ExampleService;

@RestController
@RequestMapping("/example")
public class ExampleController {
	
	@Autowired
	private ExampleService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> insert(@Valid @RequestBody ExampleRequest request) {
		ExampleEntity example = ExampleConverter.convertFromRequest(request);
		
		example = service.save(example);
		
		return ResponseEntity.ok(example);
	}

	@GetMapping(value = {"", "/{exampleId}"})
	public ResponseEntity<?> getById(@PathVariable(required = true) Long exampleId) {
		return ResponseEntity.ok(service.findById(exampleId).get());
	}

	@GetMapping("/oi")
	public String teste() {
		return "tchau de dentro do docker";
	}
}