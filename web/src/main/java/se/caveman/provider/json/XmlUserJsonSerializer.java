package se.caveman.provider.json;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import se.caveman.model.xml.XmlUser;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class XmlUserJsonSerializer implements MessageBodyWriter<XmlUser>, MessageBodyReader<XmlUser> {

    private static final Gson gson = new GsonBuilder().registerTypeAdapter(XmlUser.class, new XmlUserAdapter()).create();

    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return aClass.isAssignableFrom(XmlUser.class);
    }

    public XmlUser readFrom(Class<XmlUser> aClass, Type type, Annotation[] annotations, MediaType mediaType,
                            MultivaluedMap<String, String> multivaluedMap, InputStream inputStream)
            throws IOException, WebApplicationException {

        return gson.fromJson(new InputStreamReader(inputStream), XmlUser.class);
    }

    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return aClass.isAssignableFrom(XmlUser.class);
    }

    public void writeTo(XmlUser xmlUser, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        try (JsonWriter writer = new JsonWriter(new OutputStreamWriter(outputStream))) {
            gson.toJson(xmlUser, XmlUser.class, writer);
        }
    }

    private static final class XmlUserAdapter implements JsonSerializer<XmlUser>, JsonDeserializer<XmlUser> {

        @Override
        public JsonElement serialize(XmlUser xmlUser, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject json = new JsonObject();
            json.addProperty("id", xmlUser.getId());
            json.addProperty("username", xmlUser.getUsername());
            json.addProperty("password", xmlUser.getPassword());

            return json;
        }

        @Override
        public XmlUser deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return null;
        }

    }

    public long getSize(XmlUser xmlUser, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }
}
