package br.com.ss.api.service;

import java.util.ArrayList;
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
		return allCities.stream().filter(citie -> citie.getCapital() == true)
				.sorted(Comparator.comparing(CityDTO::getName)).collect(Collectors.toList());
	}

	public CityDTO showCityByIbgeId(String ibgeId) {
		List<CityDTO> allCities = ReadCSV.readCSVCitys();
		List<CityDTO> result = allCities.stream().filter(citie -> citie.getIbgeId().equals(ibgeId))
				.collect(Collectors.toList());
		return !CollectionUtils.isEmpty(result) ? result.get(0) : null;
	}

	public List<String> listCityNameByState(String state) {
		List<CityDTO> allCities = ReadCSV.readCSVCitys();
		return allCities.stream().filter(citie -> citie.getUf().toUpperCase().equals(state.toUpperCase()))
				.map(city -> city.getName()).collect(Collectors.toList());
	}

	public Integer getRegisterQuantity() {
		return ReadCSV.getRegisterQuantity();
	}

	public List<CityDTO> filterCitiesByCol(String coluna, String valor) {
		List<CityDTO> result = new ArrayList<>();
		List<CityDTO> allCities = ReadCSV.readCSVCitys();
		String value = valor.toUpperCase();
		switch (coluna) {
		case "ibge_id":
			result = allCities.stream().filter(citie -> citie.getIbgeId() != null && citie.getIbgeId().toUpperCase().contains(value)).collect(Collectors.toList());
			break;
		case "uf":
			result = allCities.stream().filter(citie -> citie.getUf() != null && citie.getUf().toUpperCase().contains(value)).collect(Collectors.toList());
			break;
		case "name":
			result = allCities.stream().filter(citie -> citie.getName() != null && citie.getName().toUpperCase().contains(value)).collect(Collectors.toList());
			break;
		case "capital":
			result = allCities.stream().filter(citie -> citie.getCapital() != null && String.valueOf(citie.getCapital()).toUpperCase().contains((value))).collect(Collectors.toList());
			break;
		case "lon":
			result = allCities.stream().filter(citie -> citie.getLon() != null && String.valueOf(citie.getLon()).toUpperCase().contains(value)).collect(Collectors.toList());
			break;
		case "lat":
			result = allCities.stream().filter(citie -> citie.getLat() != null && String.valueOf(citie.getLat()).toUpperCase().contains(value)).collect(Collectors.toList());
			break;
		case "no_accents":
			result = allCities.stream().filter(citie -> citie.getNoAccents() != null && citie.getNoAccents().toUpperCase().contains(value)).collect(Collectors.toList());
			break;
		case "alternative_names":
			result = allCities.stream().filter(citie -> citie.getAlternativeNames() != null && citie.getAlternativeNames().toUpperCase().contains(value)).collect(Collectors.toList());
			break;
		case "microregion":
			result = allCities.stream().filter(citie -> citie.getMicroRegion() != null && citie.getMicroRegion().toUpperCase().contains(value)).collect(Collectors.toList());
			break;
		case "mesoregion":
			result = allCities.stream().filter(citie -> citie.getMesoRegion() != null && citie.getMesoRegion().toUpperCase().contains(value)).collect(Collectors.toList());
			break;
		default:
			break;
		}
		return result;
	}

}
