package guru.springfamework.spring5mvcrest.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by bogdan.kalika@gmail.com
 * Date: 5/9/2024
 */
public abstract class AbstractRestControllerTest {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
