package unsigned.fluxify.dispatchers;

import org.junit.Before;
import org.junit.Test;

import java.util.AbstractMap;

import unsigned.fluxify.stores.StoreObject;

/**
 * Created by unsigned on 03/03/16.
 */
public class TestDispatcher extends AbstractDispatcher {

    TestDispatcher dispatcher;

    @Before
    public void setup(){
        dispatcher = new TestDispatcher();
    }


    @Test(expected = IllegalArgumentException.class)
    public void nodispatch_if_null_type(){
        dispatcher.dispatch(null, new AbstractMap.SimpleEntry<String, StoreObject>("", null));

    }

    @Test(expected = IllegalArgumentException.class)
    public void nodispatch_if_null_payload(){
        dispatcher.dispatch("loltest", null);

    }

    @Test()
    public void testIfDispatch(){

    }


}
