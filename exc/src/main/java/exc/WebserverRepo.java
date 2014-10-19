package exc;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WebserverRepo extends CrudRepository<Webserver, Integer> {
   
   @Query("select distinct w.name from Webserver w ")
   List<String> selectNames();
   
   Webserver findByName(String name);

}
