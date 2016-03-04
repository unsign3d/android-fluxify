package unsigned.fluxify.dispatchers;


import com.squareup.otto.Bus;

import java.util.AbstractMap;

import unsigned.fluxify.actions.Action;
import unsigned.fluxify.stores.AbstractStore;
import unsigned.fluxify.stores.StoreObject;

/**
 * Created by Luca Bruzzone on 20/02/2016.
 *
 * This class provides the building block of a dispatcher
 * it use Square's Otto to do it
 *
 */
public abstract class AbstractDispatcher {

    private final Bus bus;


    public AbstractDispatcher() {
        bus = new Bus();
    }

    /**
     * Register an object
     * @param obj the object you want to register
     */
    public void register(final Object obj) {
        this.bus.register(obj);
    }

    /**
     * Unregister an object
     * @param obj the object you want to unregister
     */
    public void unregister(final Object obj) {
        this.bus.unregister(obj);
    }

    /**
     * Dispatch the action to the stores
     * @param type type of action
     * @param payloads payloads of the action
     */
    public void dispatch(String type, AbstractMap.SimpleEntry<String, StoreObject>... payloads) {
        if(type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Dispatcher needs a type");
        }

        if(payloads == null || payloads.length == 0) {
            throw new IllegalArgumentException("Dispatcher needs a payload");
        }

        // feed the hashmap for the action
        for (int i = 0; i < payloads.length; ++i) {
            bus.post(new Action(payloads[i].getKey(), payloads[i].getValue()));
        }

    }

    public void emitChanges(AbstractStore.StoreChangeEvent changedEvent){
        bus.post(changedEvent);
    }
}
