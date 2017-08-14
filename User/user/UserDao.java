package user;
import java.util.List;

public interface UserDao {
	
	User insert(User user) ; 
	List<User> findAll() ; 
    void update(User user)  ; 
    void delete(User user) ; 
    User findById(int user_id); 
    void deleteAll() ; 
    List<User> findByGroupId(int group_id);
	
	
	
	
	

}
