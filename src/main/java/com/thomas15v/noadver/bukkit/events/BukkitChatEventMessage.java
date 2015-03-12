package com.thomas15v.noadver.bukkit.events;

import com.thomas15v.noadver.plugin.ChatMessage;
import org.bukkit.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BukkitChatEventMessage implements ChatMessage {

    private AsyncPlayerChatEvent event;

    public BukkitChatEventMessage(AsyncPlayerChatEvent event){
        this.event = event;
    }

    @Override
    public String getMessage() {
        return event.getMessage();
    }

    @Override
    public void warnplayer(String s) {
        event.getPlayer().sendMessage(ChatColor.DARK_RED + s);
    }

    @Override
    public void setCanceled(boolean canceled) {
        event.setCancelled(true);
    }

    @Override
    public boolean isCanceled() {
        return event.isCancelled();
    }

    @Override
    public Object getHandle() {
        return event;
    }
}
