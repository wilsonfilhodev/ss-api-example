package br.com.ss.api.dto;


public class CityDTO {
	private String ibgeId;
	private String uf;
	private String name;
	private Boolean capital;
	private Double lon;
	private Double lat;
	private String noAccents;
	private String alternativeNames;
	private String microRegion;
	private String mesoRegion;
	
	public CityDTO() {
	}

	public CityDTO(String ibgeId, String uf, String name, Boolean capital, Double lon, Double lat, String noAccents,
			String alternativeNames, String microRegion, String mesoRegion) {
		this.ibgeId = ibgeId;
		this.uf = uf;
		this.name = name;
		this.capital = capital;
		this.lon = lon;
		this.lat = lat;
		this.noAccents = noAccents;
		this.alternativeNames = alternativeNames;
		this.microRegion = microRegion;
		this.mesoRegion = mesoRegion;
	}

	public String getIbgeId() {
		return ibgeId;
	}
	
	public void setIbgeId(String ibgeId) {
		this.ibgeId = ibgeId;
	}

	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getCapital() {
		return capital;
	}
	public void setCapital(Boolean capital) {
		this.capital = capital;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public String getNoAccents() {
		return noAccents;
	}
	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}
	public String getAlternativeNames() {
		return alternativeNames;
	}
	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}
	public String getMicroRegion() {
		return microRegion;
	}
	public void setMicroRegion(String microRegion) {
		this.microRegion = microRegion;
	}
	public String getMesoRegion() {
		return mesoRegion;
	}
	public void setMesoRegion(String mesoRegion) {
		this.mesoRegion = mesoRegion;
	}

	@Override
	public String toString() {
		return "CityDTO [ibgeId=" + ibgeId + ", uf=" + uf + ", name=" + name + ", capital=" + capital + ", lon=" + lon
				+ ", lat=" + lat + ", noAccents=" + noAccents + ", alternativeNames=" + alternativeNames
				+ ", microRegion=" + microRegion + ", mesoRegion=" + mesoRegion + "]";
	}

}
