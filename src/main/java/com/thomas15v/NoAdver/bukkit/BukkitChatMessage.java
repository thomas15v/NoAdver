package com.thomas15v.NoAdver.bukkit;

import com.thomas15v.NoAdver.MultiPluginLauncher;
import com.thomas15v.NoAdver.plugin.ChatMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by thomas on 09/03/15.
 */
public class BukkitChatMessage extends ChatMessage {

    private AsyncPlayerChatEvent event;

    public BukkitChatMessage(AsyncPlayerChatEvent event){
        this.event = event;
    }

    @Override
    public String getMessage() {
        return event.getMessage();
    }

    @Override
    public void warnplayer(String s) {
        event.getPlayer().sendMessage(s);
        event.setCancelled(true);
    }

    @Override
    public void setCanceled(boolean canceled) {
        event.setCancelled(true);
    }

    @Override
    public boolean isCanceled() {
        return event.isCancelled();
    }
}
