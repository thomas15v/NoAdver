package com.thomas15v.NoAdver.sponge;

import com.thomas15v.NoAdver.plugin.Plugin;
import org.spongepowered.api.event.entity.living.player.PlayerChatEvent;
import org.spongepowered.api.util.event.Subscribe;

/**
 * Created by thomas on 09/03/15.
 */
public class SpongeChatListener {

    private Plugin plugin;

    public SpongeChatListener(Plugin plugin){
        this.plugin = plugin;
    }

    @Subscribe
    public void onChat(PlayerChatEvent event){
        plugin.OnChat(new SpongeChatMessage(event));
    }

}
