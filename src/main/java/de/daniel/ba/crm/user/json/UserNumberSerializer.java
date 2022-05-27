package de.daniel.ba.crm.user.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.daniel.ba.crm.user.UserNumber;

import java.io.IOException;

public class UserNumberSerializer extends JsonSerializer<UserNumber> {
    @Override
    public void serialize(UserNumber o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(o.toString());
    }
}
