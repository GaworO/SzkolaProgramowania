package exercise;

import java.util.List;

public interface ExerciseDao {
		Exercise insert(Exercise exercise) ; 
		List<Exercise> findAll() ; 
		void update(Exercise exercise) ; 
		void delete(Exercise exercise) ; 
		List<Exercise> findById(int exercise_id) ; 
		void deleteAll();
	
	
	
	
	
	
}
