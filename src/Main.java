import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Request;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.InputStream;

public class Main {
    public static Character loadCharacterFromApi(String url) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        String jsonStr = response.body().string();
        //System.out.println(jsonStr);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, Character.class);
    }

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
            //Character character = loadCharacterFromResources("character.json");
            Character character = loadCharacterFromApi("http://127.0.0.1:5000/player/100");
            System.out.println("Loaded character: " + character);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}