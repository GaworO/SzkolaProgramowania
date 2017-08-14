package solution;

import java.sql.Date;

public class Solution {

    private Integer solution_id ; 
    private Date created ; 
    private Date upade; 
	private String description ;
	public Solution(Integer solution_id, Date created, Date upade, String description) {
		super();
		this.solution_id = solution_id;
		this.created = created;
		this.upade = upade;
		this.description = description;
	}
	public Integer getSolution_id() {
		return solution_id;
	}
	public void setSolution_id(Integer solution_id) {
		this.solution_id = solution_id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpade() {
		return upade;
	}
	public void setUpade(Date upade) {
		this.upade = upade;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Solution [solution_id=" + solution_id + ", created=" + created + ", upade=" + upade + ", description="
				+ description + "]";
	} 
	
	
	
	
	
}
