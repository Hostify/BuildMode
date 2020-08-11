package me.hostify.buildmode.utils;

import org.bukkit.ChatColor;

import java.util.List;

public class StringUtils {

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String[] color(List<String> list) {
        String[] messages = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            messages[i] = color(list.get(i));
        }
        return messages;
    }

}
