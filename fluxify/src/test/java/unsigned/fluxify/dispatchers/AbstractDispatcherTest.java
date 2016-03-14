package unsigned.fluxify.dispatchers;

import org.greenrobot.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.CoreMatchers.instanceOf;


import java.util.AbstractMap;

import unsigned.fluxify.stores.StoreObject;

import static org.junit.Assert.*;

/**
 * Created by unsigned on 14/03/16.
 */
@RunWith(RobolectricTestRunner.class)
public class AbstractDispatcherTest extends AbstractDispatcher {

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

    @Test
    public void testGetBus() throws Exception {
        EventBus bus = dispatcher.getBus();
        assertNotNull(bus);
        assertThat(bus, instanceOf(EventBus.class) );
    }

    @Test
    public void testRegister() throws Exception {
        EventBus bus = dispatcher.getBus();
    }

    @Test
    public void testUnregister() throws Exception {

    }

    @Test
    public void testDispatch() throws Exception {

    }

    @Test
    public void testEmitChanges() throws Exception {

    }
}