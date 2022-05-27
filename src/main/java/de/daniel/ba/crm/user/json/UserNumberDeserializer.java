package de.daniel.ba.crm.user.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.daniel.ba.crm.user.UserNumber;


import java.io.IOException;

public class UserNumberDeserializer extends JsonDeserializer<UserNumber> {
    @Override
    public UserNumber deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        UserNumber result = new UserNumber();
        result.setUserNumber(Long.valueOf(jsonParser.getText()));
        return result;
    }
}
