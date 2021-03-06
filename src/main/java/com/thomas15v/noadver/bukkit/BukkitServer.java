package com.thomas15v.noadver.bukkit;

import com.thomas15v.noadver.plugin.ChatMessage;
import com.thomas15v.noadver.plugin.Server;
import org.bukkit.Bukkit;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by thomas15v on 9/03/15.
 */
public class BukkitServer implements Server {

    private JavaPlugin launcher;
    private BukkitListener listener;

    public BukkitServer(JavaPlugin launcher, BukkitListener listener){
        this.launcher = launcher;
        this.listener = listener;
    }

    @Override
    public void runtask(Runnable runnable) {
        Bukkit.getScheduler().runTaskAsynchronously(launcher, runnable);
    }

    @Override
    public void sendMessage(ChatMessage message) {
        AsyncPlayerChatEvent event = (AsyncPlayerChatEvent) message.getHandle();
        listener.addIgnored(event);
        event.setCancelled(false);
        Bukkit.getPluginManager().callEvent(event);
        Bukkit.getServer().broadcastMessage(String.format(event.getFormat(), event.getPlayer().getDisplayName(), event.getMessage()));
    }
}
