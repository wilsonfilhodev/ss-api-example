package br.com.ss.api.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ss.api.dto.CityDTO;

public class ReadCSV {
	private static final int CITY_IBGE_ID = 0;
	private static final int CITY_UF = 1;
	private static final int CITY_NAME = 2;
	private static final int CITY_CAPITAL = 3;
	private static final int CITY_LON = 4;
	private static final int CITY_LAT = 5;
	private static final int CITY_NO_ACCENTS = 6;
	private static final int CITY_ALTERNATIVE_NAMES = 7;
	private static final int CITY_MICRO_REGION = 8;
	private static final int CITY_MMESO_REGION = 9;

	public static List<CityDTO> readCSVCitys() {
		List<CityDTO> cities = new ArrayList<>();
		File file = new File("cidades.csv");
		if (file.exists() && !file.isDirectory()) {
			BufferedReader fileReader = null;

			try {
				String line = "";
				FileReader initialFile = new FileReader(file);
				fileReader = new BufferedReader(initialFile);

				// Read CSV header
				fileReader.readLine();

				// Read customer data line by line
				while ((line = fileReader.readLine()) != null) {
					String[] tokens = line.split(",");
					if (tokens.length > 0) {
						CityDTO city = new CityDTO(tokens[CITY_IBGE_ID], tokens[CITY_UF], tokens[CITY_NAME],
								tokens[CITY_CAPITAL].equals("true") ? true : false,
								Double.parseDouble(tokens[CITY_LON]), Double.parseDouble(tokens[CITY_LAT]),
								tokens[CITY_NO_ACCENTS], tokens[CITY_ALTERNATIVE_NAMES], tokens[CITY_MICRO_REGION],
								tokens[CITY_MMESO_REGION]);

						cities.add(city);
					}
				}

				return cities;

			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<>();
			} finally {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return cities;
	}

	public static Integer getRegisterQuantity() {

		BufferedReader fileReader = null;
		Integer qtd = 0;

		try {
			fileReader = new BufferedReader(new FileReader("cidades.csv"));

			// Read CSV header
			fileReader.readLine();

			// Read customer data line by line
			while (fileReader.readLine() != null) {
				qtd++;
			}

			return qtd;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
