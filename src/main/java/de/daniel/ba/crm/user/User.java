package de.daniel.ba.crm.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import de.daniel.ba.crm.user.json.LocalDateSerializer;
import de.daniel.ba.crm.user.json.UserNumberDeserializer;
import de.daniel.ba.crm.user.json.UserNumberSerializer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "customNumber", column = @Column(name = "User_number", nullable = false))
    })
    @JsonSerialize(using = UserNumberSerializer.class)
    @JsonDeserialize(using = UserNumberDeserializer.class)
    private UserNumber UserNumber;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "User_name")
    private String name;

    @Column(name = "User_surname", nullable = false)
    private String surname;

    @Column(name = "email", nullable = false)
    private String mail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthday")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthday;


    /*@OneToMany(
            targetEntity= Address.class,
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Address> addresses;*/
}

