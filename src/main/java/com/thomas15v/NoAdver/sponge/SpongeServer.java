package com.thomas15v.NoAdver.sponge;

import com.thomas15v.NoAdver.MultiPluginLauncher;
import com.thomas15v.NoAdver.plugin.ChatMessage;
import com.thomas15v.NoAdver.plugin.Server;
import com.thomas15v.NoAdver.sponge.SpongeChatListener;
import org.spongepowered.api.Game;
import org.spongepowered.api.util.event.Event;

/**
 * Created by thomas15v on 9/03/15.
 */
public class SpongeServer implements Server {

    private MultiPluginLauncher multiPluginLauncher;
    private SpongeChatListener listener;
    private Game game;

    public SpongeServer(MultiPluginLauncher multiPluginLauncher, SpongeChatListener listener, Game game) {
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
