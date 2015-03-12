package com.thomas15v.NoAdver.plugin;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.NamingException;
import java.util.List;

/**
 * Created by thomas on 09/03/15.
 */
public class UrlMatcherTest {

    @Test
    public void testURLMatchTrue(){
        List<String> url = UrlMatcher.getUrls("Hello please join this site www.google.com");
        System.out.println(url);
        Assert.assertTrue(url.size() == 1);
    }

    @Test
    public void testURLMatchNoURL(){
        List<String> url = UrlMatcher.getUrls("I LOVE YOU GUYS, NO HOME!");
        System.out.println(url);
        Assert.assertTrue(url.size() == 0);
    }

    @Test
     public void testURLMatchINVALIDURL(){
        List<String> url = UrlMatcher.getUrls("I tried to make a server join here notaserverreallynotaserver.com!");
        System.out.println(url);
        Assert.assertTrue(url.size() == 0);
    }

    @Test
    public void testhttpurlwithparameters(){
        List<String> url = UrlMatcher.getUrls("I tried to make a server join here http://google.com/images!");
        Assert.assertTrue(url.size() == 1);
    }

    @Test
    public void testURLHttpfalse(){
        List<String> url = UrlMatcher.getUrls("I tried to make a server join here http://notaserverreallynotaserver.com?");
        System.out.println(url);
        Assert.assertTrue(url.size() == 0);
    }

    @Test
    public void testURLHttptrue(){
        List<String> url = UrlMatcher.getUrls("I tried to make a server join here http://google.com!");
        System.out.println(url);
        Assert.assertTrue(url.size() == 1);
    }

    @Test
    public void testURLMatchDirectIP(){
        List<String> url = UrlMatcher.getUrls("I tried to make a server join here 127.0.0.1");
        System.out.println(url);
        Assert.assertTrue(url.size() == 1);
    }

    //@Test //school blocked minecraft ;-;
    public void testIsMinecraftServerIP(){
        Assert.assertTrue(UrlMatcher.hasMinecraftService("play.thefantasycraft.com"));
    }

    @Test
    public void testEninSite() throws NamingException {
        Assert.assertTrue(UrlMatcher.isEnjinSite("thefantasycraft.com"));
    }

    @Test
    public void testnonEnjinSite() throws NamingException {
        System.out.println(UrlMatcher.websiteContainsMinecraftServer("minecraft-nl.gamepedia.com"));
    }
}
