package exc;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databases")
public class DatabasesController {

   @RequestMapping
   public String[] getWebservers() {
      return new String[] {"Oracle", "MySQL", "Postgress", "H2"};
   }

   @RequestMapping("/{name}")
   public String getWebserverDetail(@PathVariable String name) {
      switch (name) {
         case "Oracle":
            return "For details go to https://www.oracle.com/database/index.html";
         case "MySQL":
            return "For details go to http://www.mysql.com/";
         case "Postgress":
            // cause divide by zero exception
            int j = 3 + 3 / (3 - 3);
            return "Rather not expected to be displayed";
         default:
            throw new DatabaseNotFoundException(name);
      }
   }

   /**
    * Controller level exception handler.
    * 1. Response HTTP will be 200, not 403 Forbidden
    * 2. It could be replaced by try/catch 
    * 3. It should be replaced, because exception handling may not apply well to other methods
    * 
    * Well, that is for demonstration purpose.
    *
    * @param databaseNotFoundException the database not found exception
    * @return the string
    */
   @ExceptionHandler
   @ResponseBody
   public String controllerLevelExceptionHandler(DatabaseNotFoundException databaseNotFoundException) {
      return "Unfortunately, there is no detailed information about " + databaseNotFoundException.getMessage();
   }

}
