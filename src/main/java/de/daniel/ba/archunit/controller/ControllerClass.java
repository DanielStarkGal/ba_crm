package de.daniel.ba.archunit.controller;
// Reverse Comments bellow to fail Test ArchitekturLayerTest
//import de.daniel.ba.archunit.persistence.PersistenceClass;
import de.daniel.ba.archunit.services.ServiceClass;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerClass {
    private final ServiceClass service;
    //private final PersistenceClass persistence;

    /*public ControllerClass(ServiceClass service, PersistenceClass persistence) {
        this.service = service;
        this.persistence = persistence;
    }*/

    public ControllerClass(ServiceClass service) {
        this.service = service;
    }
}
