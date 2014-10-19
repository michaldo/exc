package exc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Setup {

   @Autowired
   WebserverRepo webserverRepo;

   @PostConstruct
   void setup() {
      webserverRepo.save(new Webserver("Tomcat", "For details go to http://tomcat.apache.org/"));
      webserverRepo.save(new Webserver("Jetty", "For details go to http://www.eclipse.org/jetty/"));
      // to cause error Resin is added twice
      webserverRepo.save(new Webserver("Resin", "For details go to http://caucho.com/"));
      webserverRepo.save(new Webserver("Resin", "For details go to http://caucho.com/"));
   }

}
