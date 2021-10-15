package com.basic01.entities;

import java.util.Objects;

public class AddressComplement {
	
	private String street;
	private String streetName;
	private String buildingNumber;
	private String city;
	private String zipcode;
	private String country;
	private String country_code;
	private Double latitude;
	private Double longitude;
	
	public AddressComplement(){}

	public AddressComplement(String street, String streetName, String buildingNumber, String city, String zipcode, String country,
			String country_code, Double latitude, Double longitude) {
		this.street = street;
		this.streetName = streetName;
		this.buildingNumber = buildingNumber;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
		this.country_code = country_code;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	

	@Override
	public String toString() {
		return "Data [street=" + street + ", streetName=" + streetName + ", buildingNumber=" + buildingNumber
				+ ", city=" + city + ", zipcode=" + zipcode + ", country=" + country + ", country_code=" + country_code
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(buildingNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressComplement other = (AddressComplement) obj;
		return Objects.equals(buildingNumber, other.buildingNumber);
	}
	
}


