package unsigned.fluxify.dispatchers;

import org.junit.Test;

import java.util.AbstractMap;

import unsigned.fluxify.stores.StoreObject;

/**
 * Created by unsigned on 03/03/16.
 */
public class TestDispatcher extends AbstractDispatcher {
    @Test(expected = IllegalArgumentException.class)
    public void nodispatch_if_null_type(){
        TestDispatcher dispatcher = new TestDispatcher();
        dispatcher.dispatch(null, new AbstractMap.SimpleEntry<String, StoreObject>("", null));

    }

    @Test(expected = IllegalArgumentException.class)
    public void nodispatch_if_null_payload(){
        TestDispatcher dispatcher = new TestDispatcher();
        dispatcher.dispatch("loltest", null);

    }
}
