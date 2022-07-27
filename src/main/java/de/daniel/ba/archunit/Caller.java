package de.daniel.ba.archunit;

import org.springframework.beans.factory.annotation.Autowired;

public class Caller {

    @Autowired
    private INotAllowedCall notAllowedCall;

    public  void A(){
        notAllowedCall.allowed();
        //notAllowedCall.notAllowed();
    }
}
