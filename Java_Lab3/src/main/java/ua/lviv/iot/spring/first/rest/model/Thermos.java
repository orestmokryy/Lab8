package ua.lviv.iot.spring.first.rest.model;

import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Thermos {
	protected double capacityInLiters;
	protected double priceInUAH;
	protected double weightInKilograms;
	protected String productionCountry;
	protected String color;
	protected String producer;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	public Thermos(double capacityInLiters, double priceInUAH, double weightInKilograms, String productionCountry,
			String color, String producer) {
	}

	public Thermos() {
	}

	public double getCapacityInLiters() {
		return capacityInLiters;
	}

	public void setCapacityInLiters(double capacityInLiters) {
		this.capacityInLiters = capacityInLiters;
	}

	public double getPriceInUAH() {
		return priceInUAH;
	}

	public void setPriceInUAH(double priceInUAH) {
		this.priceInUAH = priceInUAH;
	}

	public double getWeightInKilograms() {
		return weightInKilograms;
	}

	public void setWeightInKilograms(double weightInKilograms) {
		this.weightInKilograms = weightInKilograms;
	}

	public String getProductionCountry() {
		return productionCountry;
	}

	public void setProductionCountry(String productionCountry) {
		this.productionCountry = productionCountry;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}