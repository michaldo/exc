package exc;


public class WebserverNotFoundException extends RuntimeException {
   
   private String name;

   public WebserverNotFoundException(String name) {
      super();
      this.name = name;
   }

   @Override
   public String getMessage() {
      return name;
   }
   
   

}
