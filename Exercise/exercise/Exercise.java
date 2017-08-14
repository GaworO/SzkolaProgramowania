package exercise;

public class Exercise {
	
	
	private Integer exercise_id ; 
	private String titile ; 
	private String description ;
	public Exercise(Integer exercise_id, String titile, String description) {
		super();
		this.exercise_id = exercise_id;
		this.titile = titile;
		this.description = description;
	}
	public Integer getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(Integer exercise_id) {
		this.exercise_id = exercise_id;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Exercise [exercise_id=" + exercise_id + ", titile=" + titile + ", description=" + description + "]";
	} 
	
	
	
	
	
	
	
	
	
	
	

}
