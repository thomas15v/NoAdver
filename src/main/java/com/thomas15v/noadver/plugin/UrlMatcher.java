package com.thomas15v.noadver.plugin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                try {
                    word = word.replace(",", "").replace("?", "").replace("!", "");
                    if (word.endsWith("."))
                        word = word.substring(0, word.length() - 1);
                    if (word.contains("://")) {
                        word = word.split("://")[1];
                    }
                    if (word.contains("/"))
                        word = word.split("/")[0];
                    if (word.indexOf(".") != 3 &&isNumberic(word.replace(".", "")))
                        return null;
                    if (word.contains(":"))
                        InetAddress.getByName(word.split(":")[0]);
                    else
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
            if (url.contains(":")) {
                String[] data = url.split(":");
                socket.connect(new InetSocketAddress(data[0], Integer.parseInt(data[1])), 2000);
            }
            else
                socket.connect(new InetSocketAddress(url, 25565), 2000);
            socket.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean isEnjinSite(String url){
        try {
            if (url.contains(":"))
                url = url.split(":")[0];
            new Scanner(new URL("http://" + url + "//api/v1/api.php").openStream(), "UTF-8").useDelimiter("\\A").next();
            return true;
        }catch (Exception e){}
        return false;
    }

    public static boolean websiteContainsMinecraftServer(String website){
        try {
            website = website.replace("www.", "");
            String[] domains = {"play", "mc", "tekkit", "ftb", "tl", "pvp", "minecraft"};
            for (String domain : domains)
                if (hasMinecraftService(domain + website))
                    return true;

            //Heavy shit this lol. But WE HAVE TO BE SURE DON'T WE
            Document doc = Jsoup.connect("http://" + website).userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:35.0) Gecko/20100101 Firefox/35.0").timeout(10000).get();
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
            return true;
        }
        return false;
    }

    public static boolean isNumberic(String string){
        try {
            Integer.parseInt(string);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

}
