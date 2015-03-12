package com.thomas15v.NoAdver.sponge;

import com.thomas15v.NoAdver.util.IgnoreAbleListener;
import com.thomas15v.NoAdver.plugin.Plugin;
import org.spongepowered.api.event.entity.living.player.PlayerChatEvent;
import org.spongepowered.api.util.event.Event;
import org.spongepowered.api.util.event.Order;
import org.spongepowered.api.util.event.Subscribe;

public class SpongeChatListener extends IgnoreAbleListener<Event> {

    private Plugin plugin;

    public SpongeChatListener(Plugin plugin){
        this.plugin = plugin;
    }

    @Subscribe(order = Order.PRE, ignoreCancelled = true)
    public void onChat(PlayerChatEvent event){
        if (isIgnore(event))
            removeIgnored(event);
        else
            plugin.checkEvent(new SpongeChatMessage(event));
    }

}
