package br.com.alex.camel.kt.cucumber;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class World {
    public Map<String, Object> map = new HashMap<>();
}
