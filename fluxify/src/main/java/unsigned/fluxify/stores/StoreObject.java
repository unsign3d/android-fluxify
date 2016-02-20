package unsigned.fluxify.stores;

/**
 * Created by Luca Bruzzone on 20/02/2016.
 */
public class StoreObject {
    String id;
    boolean complete;
    Object carry;

    public StoreObject(String id, boolean complete, Object carry) {
        this.id = id;
        this.complete = complete;
        this.carry = carry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Object getCarry() {
        return carry;
    }

    public void setCarry(Object carry) {
        this.carry = carry;
    }
}
