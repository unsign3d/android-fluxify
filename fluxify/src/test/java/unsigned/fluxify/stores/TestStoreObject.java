package unsigned.fluxify.stores;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by unsigned on 04/03/16.
 *
 */
public class TestStoreObject {
    @Test
    public void test_store_object() {
        String carry = "carry";
        StoreObject so = new StoreObject("id", true, carry);

        assertEquals(so.getId(), "id");
        assertEquals(so.getCarry(), carry);
        assertEquals(so.isComplete(), true);
    }

    @Test
    public void getId(){
        String carry = "carry";
        StoreObject so = new StoreObject("id", true, carry);

        assertEquals(so.getId(), "id");

    }

    @Test
    public void getCarry(){
        String carry = "carry";
        StoreObject so = new StoreObject("id", true, carry);

        assertEquals(so.getCarry(), carry);
    }

    @Test
    public void isComplete() {
        String carry = "carry";
        StoreObject so = new StoreObject("id", true, carry);

        assertEquals(so.isComplete(), true);
    }

    @Test
    public void setCarry(){
        String carry = "carry";
        StoreObject so = new StoreObject("id", true, carry);

        assertEquals(so.getCarry(), carry);

        String carry2 = "carry2";
        so.setCarry(carry2);
        assertEquals(so.getCarry(), carry2);
    }

    @Test
    public void setComplete(){
        String carry = "carry";
        StoreObject so = new StoreObject("id", false, carry);

        assertEquals(so.isComplete(), false);
        so.setComplete(true);
        assertEquals(so.isComplete(), true);
    }


}
