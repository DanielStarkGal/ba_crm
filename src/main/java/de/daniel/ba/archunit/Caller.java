package de.daniel.ba.archunit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Caller {

    @Autowired
    private INotAllowedCall notAllowedCall;

    public  void A(){
        notAllowedCall.allowed();
        // Reverse Comment bellow to fail Test ArchUnitCallerAllPackagesTest and ArchUnitCallerTest
        //notAllowedCall.notAllowed();
    }
}
