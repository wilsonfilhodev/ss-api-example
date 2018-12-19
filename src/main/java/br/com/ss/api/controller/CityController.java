package br.com.ss.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ss.api.dto.CityDTO;
import br.com.ss.api.service.CityService;

@RestController
@RequestMapping(path = "/cidades")
public class CityController {

	@Autowired
	private CityService cityService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createFile(@RequestBody List<CityDTO> cities) {
		try {
			cityService.createCSV(cities);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Falha ao processar solicitação. Tente novamente!");
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> list() {
		List<CityDTO> cities = cityService.readCSV();
		return ResponseEntity.status(HttpStatus.OK).body(cities);
	}

}
