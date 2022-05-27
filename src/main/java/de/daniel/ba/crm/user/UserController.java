package de.daniel.ba.crm.user;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserRepository service;
    private final UserNumberGenerator generator;
    private final ObjectMapper mapper = new ObjectMapper();

    public UserController(UserRepository UserRepository, UserNumberGenerator generator) {
        this.service = UserRepository;
        this.generator = generator;
    }

    @GetMapping(value = "/{UserNumber}")
    @Operation(summary = "Get a User by its UserNumber")
    @ApiResponses(value = {
            @ApiResponse( responseCode = "200", description = "Found the User",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class),
                            examples = {
                                    @ExampleObject(name = "User Exmaple",  value = "{\n" +
                                            "  \"UserNumber\":  \"string\",\n" +
                                            "  \"gender\": \"MALE\",\n" +
                                            "  \"name\": \"string\",\n" +
                                            "  \"surname\": \"string\",\n" +
                                            "  \"mail\": \"string\",\n" +
                                            "  \"phone\": \"string\",\n" +
                                            "  \"birthday\": \"2020-12-13\"\n" +
                                            "}") }
                    )}),
            @ApiResponse(responseCode = "400", description = "Invalid UserNumber supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    public User findByUserNumber(@PathVariable("UserNumber") Long UserNumber) {
        return service.findByUserNumber(UserNumber).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User resource) {
        resource.setUserNumber(generator.generate());
        User savedResource = service.save(resource);
        return savedResource;
    }

    @PutMapping(value = "/{UserNumber}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a User by its UserNumber")
    public void update(@PathVariable("UserNumber") Long UserNumber, @RequestBody User resource) {
        Optional<User> optionalUser = service.findByUserNumber(UserNumber);
        if(optionalUser.isPresent()){
            service.save(resource);
        }
    }


    @DeleteMapping(value = "/{UserNumber}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a User by its UserNumber")
    public void deleteByUserNumber(@PathVariable("UserNumber") Long userNumber) {
        service.deleteByUserNumber(new UserNumber(userNumber));
    }

}

