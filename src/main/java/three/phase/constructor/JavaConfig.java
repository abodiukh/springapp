package three.phase.constructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author andrii
 */
//@Configuration
//@ComponentScan(basePackages = "constructor")
//@ImportResource(value = "spring-config.xml")
public class JavaConfig {

//    @Bean
    public Messenger messenger() {
        SimpleMessenger messenger = new SimpleMessenger();
        messenger.setMessage("I'am said Putin huylo");
        return messenger;
    }
}
