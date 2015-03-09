package com.thomas15v.NoAdver;

import com.thomas15v.NoAdver.bukkit.BukkitChatListener;
import com.thomas15v.NoAdver.plugin.Plugin;
import com.thomas15v.NoAdver.sponge.SpongeChatListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.spongepowered.api.event.state.ServerStartedEvent;
import org.spongepowered.api.util.event.Subscribe;

/**
 * Created by thomas on 09/03/15.
 */
@org.spongepowered.api.plugin.Plugin(id = "NoAdver", version = "0.1", name = "NoAdver")
public class MultiPluginLauncher extends JavaPlugin {

    private Plugin plugin;

    @Override
    public void onEnable() {
        this.plugin = new Plugin();
        getServer().getPluginManager().registerEvents(new BukkitChatListener(plugin, this), this);
    }

    @Subscribe
    public void onEnabled(ServerStartedEvent event){
        this.plugin = new Plugin();
        event.getGame().getEventManager().register(this, new SpongeChatListener(plugin));
    }
}
