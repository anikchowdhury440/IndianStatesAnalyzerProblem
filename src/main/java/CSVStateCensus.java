import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
	
	@CsvBindByName(column = "State", required = true)
	private String stateName;
	
	@CsvBindByName(column = "Population", required = true)
	private Long population;
	
	@CsvBindByName(column = "AreaInSqKm", required = true)
	private Long areaInSqKm;
	
	@CsvBindByName(column = "DensityPerSqKm", required = true)
	private Long densityPerSqKm;
	
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	public String getStateName() {
		return stateName;
	}
	
	public void setPopulation(Long population) {
		this.population = population;
	}
	
	public Long getPopulation() {
		return population;
	}
	
	public void setAreaInSqKm(Long areaInSqKm) {
		this.areaInSqKm = areaInSqKm;
	}
	
	public Long getAreaInSqKm() {
		return areaInSqKm;
	}
	
	public void setDensityPerSqKm(Long densityPerSqKm) {
		this.densityPerSqKm = densityPerSqKm;
	}
	
	public Long getDensityPerSqKm() {
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
