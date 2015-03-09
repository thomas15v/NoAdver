package com.thomas15v.NoAdver.bukkit;

import com.thomas15v.NoAdver.MultiPluginLauncher;
import com.thomas15v.NoAdver.util.IgnoreAbleListener;
import com.thomas15v.NoAdver.plugin.Plugin;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BukkitChatListener extends IgnoreAbleListener<Event> implements Listener {

    private MultiPluginLauncher launcher;

    public BukkitChatListener(MultiPluginLauncher launcher){
        this.launcher = launcher;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if (isIgnore(event))
            removeIgnored(event);
        else
            this.launcher.getPlugin().OnChat(new BukkitChatMessage(event));
    }
}
