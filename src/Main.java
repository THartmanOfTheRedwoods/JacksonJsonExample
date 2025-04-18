import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

public class Main {
    public static Character loadCharacterFromResources(String resourcePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Get the resource as InputStream
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Resource not found: " + resourcePath);
            }
            return mapper.readValue(inputStream, Character.class);
        }
    }


    public static void main(String[] args) {
        try {
            Character character = loadCharacterFromResources("character.json");
            System.out.println("Loaded character: " + character);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}