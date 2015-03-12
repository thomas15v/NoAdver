package com.thomas15v.noadver.bukkit.events;

import com.thomas15v.noadver.plugin.ChatMessage;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Created by thomas15v on 12/03/15.
 */
public class BukkitCommandEventMessage implements ChatMessage {

    public PlayerCommandPreprocessEvent event;

    public BukkitCommandEventMessage(PlayerCommandPreprocessEvent event){
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
        event.setCancelled(canceled);
    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public Object getHandle() {
        return event;
    }
}
