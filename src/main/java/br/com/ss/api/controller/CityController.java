package br.com.ss.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
			cityService.createCSVCities(cities);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Falha ao processar solicitação. Tente novamente!");
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> list() {
		List<CityDTO> cities = cityService.listAllCities();
		return ResponseEntity.status(HttpStatus.OK).body(cities);
	}

	@RequestMapping(method = RequestMethod.GET, params = "capitais")
	public ResponseEntity<List<CityDTO>> listCityCapitals() {
		List<CityDTO> cities = cityService.listCitiesCapitals();
		return ResponseEntity.status(HttpStatus.OK).body(cities);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{ibgeId}")
	public ResponseEntity<CityDTO> showCityByIbgeId(@PathVariable String ibgeId) {
		CityDTO city = cityService.showCityByIbgeId(ibgeId);
		if (city == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(city);
	}

	@RequestMapping(method = RequestMethod.GET, params = "estado")
	public ResponseEntity<List<String>> listCityNameByState(@RequestParam(required = true) String estado) {
		List<String> citiesNames = cityService.listCityNameByState(estado);
		return ResponseEntity.status(HttpStatus.OK).body(citiesNames);
	}

}
