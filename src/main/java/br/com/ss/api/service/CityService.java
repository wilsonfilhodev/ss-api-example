package br.com.ss.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ss.api.csv.ReadCSV;
import br.com.ss.api.csv.WriteCSV;
import br.com.ss.api.dto.CityDTO;

@Service
public class CityService {
	
	public void createCSV(List<CityDTO> cities) {
		WriteCSV.writeCSVCities(cities);
	}

	public List<CityDTO> readCSV() {
		return ReadCSV.readCSVCitys();
	}
}
