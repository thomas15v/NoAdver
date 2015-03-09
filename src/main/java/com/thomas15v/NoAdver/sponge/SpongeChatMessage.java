package com.thomas15v.NoAdver.sponge;

import com.thomas15v.NoAdver.plugin.ChatMessage;
import org.spongepowered.api.event.entity.living.player.PlayerChatEvent;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.message.Message;
import org.spongepowered.api.text.message.Messages;

public class SpongeChatMessage extends ChatMessage {

    private PlayerChatEvent event;

    public SpongeChatMessage(PlayerChatEvent event){
        this.event = event;
    }

    @Override
    public String getMessage() {
        return ((Message.Text) event.getMessage()).getContent();
    }

    @Override
    public void warnplayer(String s) {
        event.getPlayer().sendMessage(Messages.builder(s).color(TextColors.RED).build());
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