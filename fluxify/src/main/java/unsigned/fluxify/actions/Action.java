package unsigned.fluxify.actions;

import java.util.Map;

import unsigned.fluxify.stores.StoreObject;

/**
 * Created by Luca Bruzzone on 20/02/2016.
 *
 * This class handles the actions
 */
public class Action {
    private final String type;
    private final StoreObject payload;

    public Action(String type, StoreObject payload) {
        if(type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Action need a type");
        }

        if(payload == null) {
            throw new IllegalArgumentException("Action need a payload");
        }

        this.type = type;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public StoreObject getPayload() {
        return payload;
    }
}
