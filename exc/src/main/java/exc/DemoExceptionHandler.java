package exc;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class DemoExceptionHandler
 * IMPORTANT: I omitted logging exception to server log for simplicity,  but in real life it should be logged
 * Otherwise error context is lost. 
 * 
 */
@ControllerAdvice
public class DemoExceptionHandler {

   /**
    * Most general exception handling
    *
    * @param ex the ex
    * @return the string
    */
   @ExceptionHandler
   @ResponseStatus(HttpStatus.FORBIDDEN)
   @ResponseBody
   public String handleException(Exception ex) {
      return "General error message: something went unexpected";
   }
   
   /**
    * General exception handler, but customized for exception class.
    * That handler demonstrate handling exception from Spring DAO API
    * 
    * @param ex the ex
    * @return the string
    */
   @ExceptionHandler
   @ResponseStatus(HttpStatus.FORBIDDEN)
   @ResponseBody
   public String handleException(DataAccessException ex) {
      return "One level more deep than general handling: " + ex.getMessage();
   }
   
   /**
    * This exception handler is similar to previous but handle application exception.
    *
    * @param ex the ex
    * @return the exception message
    */
   @ExceptionHandler
   @ResponseStatus(HttpStatus.FORBIDDEN)
   @ResponseBody
   public String handleException(WebserverNotFoundException ex) {
      return "Quite detailed error handling: Not found: " + ex.getMessage();
   }


}
