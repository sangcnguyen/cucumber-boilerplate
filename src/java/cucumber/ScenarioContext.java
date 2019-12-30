package cucumber;

import enums.Context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> context;

    public ScenarioContext() {
        context = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        context.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return context.get(key.toString());
    }
}