package de.daniel.ba.crm.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select c from User c where c.UserNumber.userNumber = :UserNumber")
    Optional<User> findByUserNumber(@Param("UserNumber") long UserNumber);

    @Query("SELECT max(c.UserNumber) FROM User c")
    Optional<UserNumber> findHighgestUserNumber();

    long deleteByUserNumber(UserNumber UserNumber);
}