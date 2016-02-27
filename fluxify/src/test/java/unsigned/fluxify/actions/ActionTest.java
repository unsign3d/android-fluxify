package unsigned.fluxify.actions;

import org.junit.Test;
import static org.junit.Assert.*;

import unsigned.fluxify.stores.StoreObject;

/**
 * Created by Luca Bruzzone on 27/02/2016.
 *
 * This is the class for testing the action
 */

public class ActionTest {

    @Test
    public void successfullyCreateAction(){
        String type = "type";

        Action action = new Action(type, new StoreObject(
                "store_id", false, "Teststring"
        ));

        assertEquals(action.getType(), type);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notCreateActionIfNoType(){
        Action action = new Action(null, new StoreObject(
                "store_id", false, "Teststring"
        ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void notCreateActionIfNoCarry(){
        String type = "type";

        Action action = new Action(type,null);
    }

}
