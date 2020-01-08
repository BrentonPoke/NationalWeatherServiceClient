package gov.noaa.gridpoints;

import com.google.gson.annotations.SerializedName;

public class Value{

	@SerializedName("validTime")
	private String validTime;

	@SerializedName("value")
	private double value;
}