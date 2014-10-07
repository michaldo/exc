package exc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webservers")
public class WebServers {
	
	@RequestMapping
	public String[] getWebservers() {
		return new String[] {"Tomcat", "Jetty", "iPlanet"};
	}
	
	@RequestMapping("/{webserver}")
	public String getWebserverDetail(@PathVariable String webserver) {
		switch (webserver) {
			case "Tomcat": return "Apache";
			case "Jetty" : return "Eclipse";
			default : throw new IllegalArgumentException();
		}
	}

	
}
