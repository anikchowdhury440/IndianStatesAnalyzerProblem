import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
	
	@CsvBindByName(column = "State", required = true)
	private String stateName;
	
	@CsvBindByName(column = "Population", required = true)
	private String population;
	
	@CsvBindByName(column = "AreaInSqKm", required = true)
	private String areaInSqKm;
	
	@CsvBindByName(column = "DensityPerSqKm", required = true)
	private String densityPerSqKm;
	
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	public String getStateName() {
		return stateName;
	}
	
	public void setPopulation(String population) {
		this.population = population;
	}
	
	public String getPopulation() {
		return population;
	}
	
	public void setAreaInSqKm(String areaInSqKm) {
		this.areaInSqKm = areaInSqKm;
	}
	
	public String getAreaInSqKm() {
		return areaInSqKm;
	}
	
	public void setDensityPerSqKm(String densityPerSqKm) {
		this.densityPerSqKm = densityPerSqKm;
	}
	
	public String getDensityPerSqKm() {
		return densityPerSqKm;
	}
	
	@Override
	public String toString() {
		return  "stateName='" + stateName + '\'' +
	                ", population='" + population + '\'' +
	                ", areaInSqKm='" + areaInSqKm + '\'' +
	                ", densityPerSqKm='" + densityPerSqKm + '\''
	                +"\n";
	}
}
