package com.thomas15v.noadver.plugin;

import java.util.List;
import java.util.Map;

public class Plugin {

    private final Server server;

    public Plugin(Server server){
        this.server = server;
    }

    public Map<String, List<String>> history;

    public void checkEvent(final ChatMessage chatMessage){
        for (final String url : UrlMatcher.getUrls(chatMessage.getMessage())) {
            if (UrlMatcher.hasMinecraftService(url) || UrlMatcher.isEnjinSite(url)) {
                chatMessage.warnplayer("Advertising is not allowed!");
            }
            else {
                chatMessage.warnplayer("Checking your url on advertising....");
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        if (UrlMatcher.websiteContainsMinecraftServer(url))
                            chatMessage.warnplayer("Advertising is not allowed!");
                        else
                            server.sendMessage(chatMessage);
                    }
                };
                server.runtask(task);
            }
            chatMessage.setCanceled(true);
        }
    }
}
