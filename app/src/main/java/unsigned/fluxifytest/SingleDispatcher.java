package unsigned.fluxifytest;

import unsigned.fluxify.dispatchers.AbstractDispatcher;

/**
 * Created by Luca Bruzzone on 20/02/2016.
 *
 * This is an implementation of the AbstractDispatcher from the fuxify lib
 */
public class SingleDispatcher extends AbstractDispatcher {

    private static SingleDispatcher __instance = null;

    public static SingleDispatcher getInstance(){
        if(__instance == null){
            __instance = new SingleDispatcher();
        }

        return __instance;
    }

    private SingleDispatcher(){
        super();
    }
}
