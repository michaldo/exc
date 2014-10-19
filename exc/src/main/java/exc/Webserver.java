package exc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Webserver {

   @Id
   @GeneratedValue
   private Integer id;

   private String name;
   
   private String description;

   public Webserver() {
   }
   
   public Webserver(String name, String description) {
      this.name = name;
      this.description = description;
   }


   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

}
