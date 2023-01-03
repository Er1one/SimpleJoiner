package ru.er1one.simplejoiner.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String color(String string) {
        Pattern pattern = Pattern.compile("&#[a-fA-F0-9]{6}"); // #ffffff - &f
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String color = string.substring(matcher.start() + 1, matcher.end());
            string = string.replace("&" + color, ChatColor.of(color) + "");
            matcher = pattern.matcher(string);
        }
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static List<String> color(List<String> list) {
        List<String> result = new ArrayList<>();
        list.forEach(key -> result.add(color(key)));
        return result;
    }

    public static void sendList(Player player, List<String> list) {
        list.forEach(message -> player.sendMessage(color(message)));
    }

    public static void broadcast(String message) {
        Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(color(message)));
    }

    public static void broadcast(List<String> message) {
        Bukkit.getOnlinePlayers().forEach(player -> sendList(player, message));
    }

    public static void broadcastActionBar(String message) {
        Bukkit.getOnlinePlayers().forEach(player -> player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(color(message))));
    }

    public static void broadcastTitle(String title) {
        Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(title, null, 5, 40, 5));
    }

    public static void broadcastTitle(String title, String subTitle) {
        Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(title, subTitle, 5, 40, 5));
    }

    public static void broadcast(Sound sound) {
        Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player.getLocation(), sound, 1F, 0.7F));
    }

}
