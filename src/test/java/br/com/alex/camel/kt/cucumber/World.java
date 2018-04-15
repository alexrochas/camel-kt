package br.com.alex.camel.kt.cucumber;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class World {
    public Map<String, Object> map = new HashMap<>();

    public World() {
        map.put("verbs", Map.of(
                "add", HttpMethod.POST,
                "search", HttpMethod.GET,
                "delete", HttpMethod.DELETE,
                "update", HttpMethod.PUT
        ));
    }
}
