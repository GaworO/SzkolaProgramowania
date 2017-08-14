package group;

import java.util.List;

public interface GroupDao {

	
	Group insert(Group group) ; 
	List<Group> findAll() ; 
	void update(Group group); 
	void delete(Group group) ; 
	List<Group> findById(Group group) ; 
	void deleteAll();
	
	
	
	
	
	
	
	
	
	
	
	
	
}
