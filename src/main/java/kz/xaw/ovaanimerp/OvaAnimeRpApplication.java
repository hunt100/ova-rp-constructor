package kz.xaw.ovaanimerp;

import com.mitchellbosecke.pebble.boot.autoconfigure.PebbleAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        PebbleAutoConfiguration.class
})
public class OvaAnimeRpApplication {

    public static void main(String[] args) {
        SpringApplication.run(OvaAnimeRpApplication.class, args);
    }

}
