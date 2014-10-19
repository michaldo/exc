package exc;


public class DatabaseNotFoundException extends RuntimeException {
   
   private String name;

   public DatabaseNotFoundException(String name) {
      super();
      this.name = name;
   }

   @Override
   public String getMessage() {
      return name;
   }
   
   

}
