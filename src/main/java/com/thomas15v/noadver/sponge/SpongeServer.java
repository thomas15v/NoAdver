package com.thomas15v.noadver.sponge;

import com.thomas15v.noadver.MultiPluginLauncher;
import com.thomas15v.noadver.plugin.ChatMessage;
import com.thomas15v.noadver.plugin.Server;
import com.thomas15v.noadver.sponge.SpongeListener;
import org.spongepowered.api.Game;
import org.spongepowered.api.util.event.Event;

/**
 * Created by thomas15v on 9/03/15.
 */
public class SpongeServer implements Server {

    private MultiPluginLauncher multiPluginLauncher;
    private SpongeListener listener;
    private Game game;

    public SpongeServer(MultiPluginLauncher multiPluginLauncher, SpongeListener listener, Game game) {
        this.multiPluginLauncher = multiPluginLauncher;
        this.listener = listener;
        this.game = game;
    }

    @Override
    public void runtask(Runnable runnable) {
        //runnable.run();
        game.getSyncScheduler().runTask(multiPluginLauncher, runnable);
    }

    @Override
    public void sendMessage(ChatMessage message) {
        Event event = (Event) message.getHandle();
        listener.addIgnored(event);
        game.getEventManager().post(event);

    }
}
