package com.thomas15v.NoAdver.plugin;

public abstract class ChatMessage {

    public abstract String getMessage();

    public abstract void warnplayer(String s);

    public abstract void setCanceled(boolean canceled);

    public abstract boolean isCanceled();
}
