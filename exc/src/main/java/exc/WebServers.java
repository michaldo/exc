package exc;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webservers")
public class WebServers {
	
	@RequestMapping
	public String[] getWebservers() {
		return new String[] {"Tomcat", "Jetty", "iPlanet"};
	}
	
}
