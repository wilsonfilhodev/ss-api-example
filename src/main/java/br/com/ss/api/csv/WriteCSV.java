package br.com.ss.api.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.ss.api.dto.CityDTO;

public class WriteCSV {
	private static final String CSV_HEADER = "ibge_id, uf, name, capital, lon, lat, no_accents, alternative_names, microregion, mesoregion";
	 
	public static void writeCSVCities(List<CityDTO> cities) {
 
		FileWriter fileWriter = null;
 
		try {
			fileWriter = new FileWriter("cidades.csv");
 
			fileWriter.append(CSV_HEADER);
			fileWriter.append('\n');
 
			for (CityDTO city : cities) {
				fileWriter.append(parseFieldString(city.getIbgeId()));
				fileWriter.append(',');
				fileWriter.append(parseFieldString(city.getUf()));
				fileWriter.append(',');
				fileWriter.append(parseFieldString(city.getName()));
				fileWriter.append(',');
				fileWriter.append(parseValueCapital(city));
				fileWriter.append(',');
				fileWriter.append(parseFieldString(city.getLon()));
				fileWriter.append(',');
				fileWriter.append(parseFieldString(city.getLat()));
				fileWriter.append(',');
				fileWriter.append(parseFieldString(city.getNoAccents()));
				fileWriter.append(',');
				fileWriter.append(parseFieldString(city.getAlternativeNames()));
				fileWriter.append(',');
				fileWriter.append(parseFieldString(city.getMicroRegion()));
				fileWriter.append(',');
				fileWriter.append(parseFieldString(city.getMesoRegion()));
				fileWriter.append('\n');
			}
 
			System.out.println("Write CSV successfully!");
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Flushing/closing error!");
				e.printStackTrace();
			}
		}
	}

	private static CharSequence parseFieldString(Object value) {
		return value != null ? String.valueOf(value) : "";
	}
	
	
	private static CharSequence parseValueCapital(CityDTO city) {
		return city.getCapital() != null ? city.getCapital() ? "true" : "" : "";
	}
}
