package com.thomas15v.NoAdver.plugin;

/**
 * Created by thomas15v on 9/03/15.
 */
public interface Server {

    public void runtask(Runnable runnable);

    public void sendMessage(ChatMessage message);
}
