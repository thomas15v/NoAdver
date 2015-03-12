package com.thomas15v.NoAdver;

import com.thomas15v.NoAdver.bukkit.BukkitListener;
import com.thomas15v.NoAdver.bukkit.BukkitServer;
import com.thomas15v.NoAdver.plugin.Plugin;
import com.thomas15v.NoAdver.sponge.SpongeChatListener;
import com.thomas15v.NoAdver.sponge.SpongeServer;
import org.bukkit.plugin.java.JavaPlugin;
import org.spongepowered.api.event.state.ServerStartedEvent;
import org.spongepowered.api.util.event.Subscribe;

@org.spongepowered.api.plugin.Plugin(id = "NoAdver", version = "0.1", name = "NoAdver")
public class MultiPluginLauncher extends JavaPlugin {

    private Plugin plugin;

    @Override
    public void onEnable() {
        BukkitListener listener = new BukkitListener(this);
        this.plugin = new Plugin(new BukkitServer(this, listener));
        getServer().getPluginManager().registerEvents(listener, this);
    }

    @Subscribe
    public void onEnable(ServerStartedEvent event){
        SpongeChatListener listener = new SpongeChatListener(plugin);
        this.plugin = new Plugin(new SpongeServer(this, listener, event.getGame()));
        event.getGame().getEventManager().register(this, listener);
    }

    public Plugin getPlugin() {
        return plugin;
    }
}