Mini tutorial on fluxify
========================

The spirit of the lib
---------------------

The spirit of the fluxify lib is to have the bare minimun library in order to do a pub/sum messaging library in a Flux way, so you won't find:

-	REST API client or whatever you need to comunicate with your web app
-	Components or something that handles components
-	A standard way to call your Actions, this library is agnostic, but you will need to call it as a String

What you will have is:

-	An angine to quickly create stores, actions and dispatchers
-	You have basically all the flexibility to implement your own flux implementation in the way you think best handles your needs, for example you can have a single dispatcher like the demo app or you can have multiple dispatchers, that will be handled in a good way

How to use it
-------------

If you don't already know what Flux is I suggest you to google a lot of information and came here when you have a VERY CLEAR IDEA of what you are doing.

If you know what Flux is and you know basic OOP you are in the right place.

All classes are under unsigned.fluxify package, the subpackages are divided by the services that they're doing it for you. All classes are Abstract classes, I didn't use interfaces in order to comunicate and have different solutions because is a really small and basic library and it aim to be really fast to learn and to hack.

Dispatchers
-----------

Dispatchers in my Flux vision are just a simple abstraction of the use of an eventbus. I choose Otto because it was what I already knew and googling I didn't find any compelling reason not to use it.

So if you want to make your own dispatcher you can just implement fluxify.dispatchers.AbstractDispatcher, a good IDE will tells you what method you need to implement and what not. In my opinion if you don't have needs you should not override methods, if you feel the need to it please PR your changes.

The last think you need to know is that you need to dispatch AbstractMap.SimpleEntry because hashmaps.

The only problem for now, and it needs to change somehow (Issue me or PR me if you have ideas), is that your project will need to have otto installed as a dependency and you need to use the @Subscribe java annotation in order to receive the StoreChangeEvent.

Actions
-------

The action is basically a POJO, you just need to have a type and a StoreObject which is the carry of the message.

In a classic pub/sub messaging, this is the message handler, so I choosed it to be the lightest and shortest as possible.

Stores
------

Here comes the best part, in your application in theory this is when you have to do the heavy lifting.

The AbstractStore handles the bare minimum, it has a state (we need to improve it) and it has the carry.

Quick notice, in a store you need to subclass the StoreChangeEvent and bind it to the emitStoreChanged in order to make it work and to handle better the way you need to handle store changes.

The idea is to implement it like this

```java
@Override
public void emitStoreChanged() {
    dispatcher.emitChanges(new MyStoreChangedEvent());
}
```

doing that you can handle more advanced type of store changing (eg. updated vs created).

Views
-----

We don't need views in our ecosystem because Android has a deep influence in how the view is handled so in my opinion the view is just your Activity, nothing more.
