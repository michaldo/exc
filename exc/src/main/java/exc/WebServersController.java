package exc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webservers")
public class WebServersController {
   
   @Autowired
   WebserverRepo x;

   @RequestMapping
   public List<String> getList() {
      List<String> servers = new ArrayList<>(x.selectNames());
      // add fake 
      servers.add("Ford");
      
      return servers;
   }

   @RequestMapping("/{name}")
   public String getDetail(@PathVariable String name) {
      Webserver w = x.findByName(name);
      if (w == null) {
         throw new WebserverNotFoundException(name);
      }
      return w.getDescription();
   }

}
