package br.com.ss.api.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.ss.api.csv.ReadCSV;
import br.com.ss.api.csv.WriteCSV;
import br.com.ss.api.dto.CityDTO;

@Service
public class CityService {
	
	public void createCSVCities(List<CityDTO> cities) {
		WriteCSV.writeCSVCities(cities);
	}

	public List<CityDTO> listAllCities() {
		return ReadCSV.readCSVCitys();
	}
	
	public List<CityDTO> listCitiesCapitals() {
		List<CityDTO> allCities = ReadCSV.readCSVCitys();
		return allCities.stream()
			.filter(citie -> citie.getCapital() == true)
			.sorted(Comparator.comparing(CityDTO::getName))
			.collect(Collectors.toList());
	}
	
	public CityDTO showCityByIbgeId(String ibgeId) {
		List<CityDTO> allCities = ReadCSV.readCSVCitys();
		List<CityDTO> result = allCities.stream()
			.filter(citie -> citie.getIbgeId().equals(ibgeId))
			.collect(Collectors.toList());
		return !CollectionUtils.isEmpty(result) ? result.get(0) : null;
	}
	
	public List<String> listCityNameByState(String state) {
		List<CityDTO> allCities = ReadCSV.readCSVCitys();
		return allCities.stream()
			.filter(citie -> citie.getUf().toUpperCase().equals(state.toUpperCase()))
			.map(city -> city.getName())
			.collect(Collectors.toList());
	}
	
}
