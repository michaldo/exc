package exc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Index {

   @RequestMapping
   public String hello() {
      System.out.println("Hello");
      return "Hello";
   }

}
