package cartracker.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * Created by mannu.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Reading.getAll",
                query = "SELECT reading FROM Reading reading"),
        @NamedQuery(name = "Reading.getReadingsByVin",
                query = "SELECT reading FROM Reading reading WHERE vin=:paramsVIN")
})
public class Reading {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String vin;
    private double latitude;
    private double longitude;
    private Timestamp timestamp;
    private float fuelVolume;
    private int speed;
    private int engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private int engineRpm;

    @OneToOne
    private Tire tires;

    public Reading() {
        this.id = UUID.randomUUID().toString();
    }

    

    public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getVin() {
		return vin;
	}



	public void setVin(String vin) {
		this.vin = vin;
	}



	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public Timestamp getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}



	public float getFuelVolume() {
		return fuelVolume;
	}



	public void setFuelVolume(float fuelVolume) {
		this.fuelVolume = fuelVolume;
	}



	public int getSpeed() {
		return speed;
	}



	public void setSpeed(int speed) {
		this.speed = speed;
	}



	public int getEngineHp() {
		return engineHp;
	}



	public void setEngineHp(int engineHp) {
		this.engineHp = engineHp;
	}



	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}



	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}



	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}



	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}



	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}



	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}



	public int getEngineRpm() {
		return engineRpm;
	}



	public void setEngineRpm(int engineRpm) {
		this.engineRpm = engineRpm;
	}



	public Tire getTires() {
		return tires;
	}



	public void setTires(Tire tires) {
		this.tires = tires;
	}



	@Override
    public String toString() {
        return "Reading{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timeStamp=" + timestamp +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRpm=" + engineRpm +
                ", tires=" + tires +
                '}';
    }
}
