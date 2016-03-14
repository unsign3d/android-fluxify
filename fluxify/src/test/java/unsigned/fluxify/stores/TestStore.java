package unsigned.fluxify.stores;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import unsigned.fluxify.actions.Action;
import unsigned.fluxify.dispatchers.AbstractDispatcher;

/**
 * Created by unsigned on 14/03/16.
 *
 */
public class TestStore extends AbstractStore {
    /**
     * Constructor of the class
     *
     * @param dispatcher the dispatcher which you want to connect the store
     */

    public int events;

    public TestStore(AbstractDispatcher dispatcher) {
        super(dispatcher);
        events = 0;
    }

    @Override
    public void emitStoreChanged() {
        events++;
    }

    @Override
    @Subscribe
    public void onAction(Action action) {
        // bind every action to the store
        create(action.getPayload());
        emitStoreChanged();

    }

    public class TestStoreChangeEvent extends StoreChangeEvent{}

}
