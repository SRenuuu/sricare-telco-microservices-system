package lk.ucsc.sricare.serviceissuesservice;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

@Component
public class BrowserLauncher{

    @EventListener(ApplicationReadyEvent.class)
    public void launchBrowser(){

        System.setProperty("java.awt.headless", "false");
        Desktop desktop = Desktop.getDesktop();

        try{
            desktop.browse(new URI("http://localhost:8080/swagger-ui/index.html"));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}