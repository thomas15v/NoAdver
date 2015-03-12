package com.thomas15v.noadver.sponge;

import com.thomas15v.noadver.sponge.events.SpongeChatEventMessage;
import com.thomas15v.noadver.sponge.events.SpongeCommandEventMessage;
import com.thomas15v.noadver.util.IgnoreAbleListener;
import com.thomas15v.noadver.plugin.Plugin;

import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.event.entity.living.player.PlayerChatEvent;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.util.event.Event;
import org.spongepowered.api.util.event.Order;
import org.spongepowered.api.util.event.Subscribe;

public class SpongeListener extends IgnoreAbleListener<Event> {

    private Plugin plugin;

    public SpongeListener(Plugin plugin){
        this.plugin = plugin;
    }

    @Subscribe(order = Order.LAST, ignoreCancelled = true)
    public void onChat(PlayerChatEvent event){
        if (isIgnore(event))
            removeIgnored(event);
        else
            plugin.checkEvent(new SpongeChatEventMessage(event));
    }
    
    @Subscribe(order = Order.LAST, ignoreCancelled = true)
    public void onCommand(CommandEvent event){
        
    	// Ignore commands sent from console
    	if(!(event.getSource() instanceof Player))
    		return;
    	
    	if (isIgnore(event))
            removeIgnored(event);
        else
            plugin.checkEvent(new SpongeCommandEventMessage(event));
    }

}
