package de.daniel.ba.crm.user;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Random;

@Component
public class UserNumberGenerator {

    private final UserRepository service;

    public UserNumberGenerator(UserRepository service) {
        this.service = service;
    }

    public UserNumber generate() {
        Optional<UserNumber> highest = service.findHighgestUserNumber();
        if (highest.isPresent()){
            return new UserNumber(highest.get().getUserNumber() + new Random().nextInt(51));
        }
        return new UserNumber((long) new Random().nextInt(100));
    }
}
