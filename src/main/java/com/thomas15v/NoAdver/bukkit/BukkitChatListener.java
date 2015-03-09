package com.thomas15v.NoAdver.bukkit;

import com.thomas15v.NoAdver.MultiPluginLauncher;
import com.thomas15v.NoAdver.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BukkitChatListener implements Listener {

    private Plugin plugin;
    private MultiPluginLauncher launcher;

    public BukkitChatListener(Plugin plugin, MultiPluginLauncher launcher){
        this.plugin = plugin;
        this.launcher = launcher;
    }

    public void onChat(AsyncPlayerChatEvent event){
        plugin.OnChat(new BukkitChatMessage(event));
    }

}
