package de.daniel.ba.archunit;

import org.springframework.stereotype.Service;

@Service
public class NotAllowedCall implements INotAllowedCall{

    @Override
    public void allowed() {

    }

    @Override
    public void notAllowed() {

    }
}
