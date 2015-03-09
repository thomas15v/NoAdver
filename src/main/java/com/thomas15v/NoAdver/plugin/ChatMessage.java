package com.thomas15v.NoAdver.plugin;

/**
 * Created by thomas on 09/03/15.
 */
public abstract class ChatMessage {

    public abstract String getMessage();

    public abstract void warnplayer(String s);

    public abstract void setCanceled(boolean canceled);

    public abstract boolean isCanceled();
}
