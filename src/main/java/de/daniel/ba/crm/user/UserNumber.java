package de.daniel.ba.crm.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNumber {

    private long userNumber;

    @Override
    public String toString(){
        return String.format("%012d", this.userNumber);
    }


}
