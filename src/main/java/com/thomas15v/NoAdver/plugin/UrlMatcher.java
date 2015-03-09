package com.thomas15v.NoAdver.plugin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import sun.net.www.content.audio.wav;

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thomas on 09/03/15.
 */
public class UrlMatcher {

    public static List<String> getUrls(String string){
        List<String> data = new ArrayList<String>();
        for (String word : string.split(" ")){
            String url = getUrl(word);
            if (url != null)
                data.add(url);
        }
        return data;
    }

    private static String getUrl(String word){
            if (word.length() > 1 && word.contains(".") && !word.contains(" ")) {
                System.out.println(word);
                try {
                    word = word.replace(",", "").replace("?", "").replace("!", "");
                    if (word.endsWith("."))
                        word = word.substring(0, word.length() - 1);
                    if (word.contains("://")) {
                        word = word.split("://")[1];
                    }
                    if (word.contains("/"))
                        word = word.split("/")[0];
                    InetAddress.getByName(word);
                    return word;
                } catch (UnknownHostException e) {
                }
            }
        return null;
    }

    public static boolean hasMinecraftService(String url){
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(url, 25565), 2000);
            socket.close();
            System.out.println("This is a minecraft server: " + url);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean isEnjinSite(String url){
        try {
            new Scanner(new URL("http://" + url + "//api/v1/api.php").openStream(), "UTF-8").useDelimiter("\\A").next();
            System.out.println("This is an enjin site: " + url);
            return true;
        }catch (Exception e){}
        return false;
    }

    public static boolean websiteContainsMinecraftServer(String website){
        try {
            website = website.replace("www.", "");
            if (hasMinecraftService("play." + website) || hasMinecraftService("mc." + website))
                return true;

            Document doc = Jsoup.connect("http://" + website).userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:35.0) Gecko/20100101 Firefox/35.0").get();
            Elements elements = doc.select("a,p,span,h1,h2,h3,h4,h5");
            List<String> checked = new ArrayList<>();
            for (Element element : elements){
                String url = getUrl(element.html());
                if (url != null && !checked.contains(url)) {
                    checked.add(url);
                    System.out.println(checked);
                    if (hasMinecraftService(url) || isEnjinSite(url)) {
                        System.out.println("We found this " + url);
                        return true;
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
