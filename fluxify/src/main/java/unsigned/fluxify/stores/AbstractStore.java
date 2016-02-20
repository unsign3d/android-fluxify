package unsigned.fluxify.stores;

import java.util.HashMap;
import java.util.Map;

import unsigned.fluxify.actions.Action;
import unsigned.fluxify.dispatchers.AbstractDispatcher;

/**
 * Created by Luca Bruzzone on 20/02/2016.
 *
 * This class is the ground for creating a new store
 */
public abstract class AbstractStore {
    protected final AbstractDispatcher dispatcher;
    private Map<String, StoreObject> items;

    /**
     * Constructor of the class
     * @param dispatcher the dispatcher which you want to connect the store
     */
    public AbstractStore(AbstractDispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.items = new HashMap<>();
    }

    /**
     * You need to call it when a store change event
     */
    public abstract void emitStoreChanged();

    /**
     * @param object a store oblject
     */
    public void create(StoreObject object) {
        items.put(object.getId(), object);
    }

    /**
     * Destroy an object from the items of the store
     * @param id
     */
    public void destroy(String id) {
        items.remove(id);
    }

    public abstract void onAction(Action action);

    public class StoreChangeEvent{}



    public Map<String, StoreObject> getItems() {
        return items;
    }
}
