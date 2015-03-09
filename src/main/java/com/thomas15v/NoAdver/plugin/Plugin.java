package com.thomas15v.NoAdver.plugin;

public class Plugin {

    public void OnChat(ChatMessage chatMessage){
        for (String url : UrlMatcher.getUrls(chatMessage.getMessage()))
            if (UrlMatcher.hasMinecraftService(url) || UrlMatcher.isEnjinSite(url) || UrlMatcher.websiteContainsMinecraftServer(url)){
                chatMessage.warnplayer("Advertising is not allowed!");
                chatMessage.setCanceled(true);
            }
    }
}
