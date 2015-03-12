package com.thomas15v.NoAdver.bukkit;

import com.thomas15v.NoAdver.MultiPluginLauncher;
import com.thomas15v.NoAdver.bukkit.events.BukkitChatEventMessage;
import com.thomas15v.NoAdver.bukkit.events.BukkitCommandEventMessage;
import com.thomas15v.NoAdver.util.IgnoreAbleListener;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BukkitListener extends IgnoreAbleListener<Event> implements Listener {

    private MultiPluginLauncher launcher;

    public BukkitListener(MultiPluginLauncher launcher){
        this.launcher = launcher;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if (isIgnore(event))
            removeIgnored(event);
        else
            this.launcher.getPlugin().checkEvent(new BukkitChatEventMessage(event));
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        if (isIgnore(event))
            removeIgnored(event);
        else
            this.launcher.getPlugin().checkEvent(new BukkitCommandEventMessage(event));

    }
}
