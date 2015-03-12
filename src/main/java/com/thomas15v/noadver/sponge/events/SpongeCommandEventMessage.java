package com.thomas15v.noadver.sponge.events;

import com.thomas15v.noadver.plugin.ChatMessage;

import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.message.Messages;

public class SpongeCommandEventMessage implements ChatMessage {

    private CommandEvent event;

    public SpongeCommandEventMessage(CommandEvent event){
        this.event = event;
    }

    @Override
    public String getMessage() {
        return "/" + event.getCommand() + " " + event.getArguments();
    }

    @Override
    public void warnplayer(String s) {
        event.getSource().sendMessage(Messages.builder(s).color(TextColors.RED).build());
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

    @Override
    public Object getHandle() {
        return event;
    }
}