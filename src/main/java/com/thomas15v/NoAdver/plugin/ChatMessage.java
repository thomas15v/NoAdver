package com.thomas15v.NoAdver.plugin;

public interface ChatMessage {

    public String getMessage();

    public void warnplayer(String s);

    public void setCanceled(boolean canceled);

    public boolean isCanceled();

    public Object getHandle();
}
