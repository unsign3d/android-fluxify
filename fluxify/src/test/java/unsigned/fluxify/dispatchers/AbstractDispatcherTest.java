package unsigned.fluxify.dispatchers;

import android.app.Activity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.CoreMatchers.instanceOf;


import java.util.AbstractMap;

import unsigned.fluxify.actions.Action;
import unsigned.fluxify.stores.AbstractStore;
import unsigned.fluxify.stores.StoreObject;
import unsigned.fluxify.stores.TestStore;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by unsigned on 14/03/16.
 */
@RunWith(RobolectricTestRunner.class)
public class AbstractDispatcherTest extends AbstractDispatcher {

    @Mock TestStore testStore;

    @InjectMocks
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
        TestStore store = mock(TestStore.class);

        dispatcher.register(store);


        assertTrue(bus.isRegistered(store));
    }

    @Test
    public void testUnregister() throws Exception {
        EventBus bus = dispatcher.getBus();

        TestStore store = mock(TestStore.class);
        dispatcher.register(store);

        dispatcher.unregister(store);

        assertFalse(bus.isRegistered(store));
    }

    @Test
    public void testDispatch() throws Exception {
        /*
        testStore = mock(TestStore.class);

        dispatcher.dispatch(
                "USELESS_BUTTON_PRESSED",
                new AbstractMap.SimpleEntry<String, StoreObject>(
                        "USELESS_BUTTON_PRESSED",
                        new StoreObject(
                                "useless_string",
                                false,
                                "Stringa inutile"
                        )
                ));

        verify(testStore).onAction(any(Action.class));
        assertEquals(1, testStore.events);
    */
    }

    @Test
    public void testEmitChanges() throws Exception {
    /*
        HandleEvent he = new HandleEvent();
        ChangeEvent ce = new ChangeEvent();

        dispatcher.register(he);

        dispatcher.emitChanges(ce);

        verify(he).handleChangeEvent(ce);
        */

    }

    class ChangeEvent extends AbstractStore.StoreChangeEvent{}

    class HandleEvent {

        public HandleEvent() {
        }

        @Subscribe
        public void handleChangeEvent(ChangeEvent ce){
            int a = 1;
            // do absolutely nothing
        }
    }
}