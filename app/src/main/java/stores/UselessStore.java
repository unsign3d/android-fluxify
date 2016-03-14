package stores;


import org.greenrobot.eventbus.Subscribe;

import unsigned.fluxify.actions.Action;
import unsigned.fluxify.dispatchers.AbstractDispatcher;
import unsigned.fluxify.stores.AbstractStore;

/**
 * Created by Luca Bruzzone on 20/02/2016.
 *
 */
public class UselessStore extends AbstractStore {

    private static UselessStore __instance;


    public static UselessStore getInstance(AbstractDispatcher dispatcher) {
        if(__instance == null) {
            __instance = new UselessStore(dispatcher);
        }
        return __instance;
    }


    /**
     * Constructor of the class
     *
     * @param dispatcher the dispatcher which you want to connect the store
     */
    private UselessStore(AbstractDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void emitStoreChanged() {
        dispatcher.emitChanges(new UselessStoreChangeEvent());
    }

    @Override
    @Subscribe
    public void onAction(Action action) {
        // bind the action to the store
        switch (action.getType()) {
            case "USELESS_BUTTON_PRESSED":
                create(action.getPayload());
                emitStoreChanged();
                break;
        }
    }

    public class UselessStoreChangeEvent extends StoreChangeEvent{}
}
