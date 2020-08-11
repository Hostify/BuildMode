package me.hostify.buildmode.utils;

import me.hostify.buildmode.BuildMode;

public class MessageUtils {

    public static String getPrefix() {
        return StringUtils.color(BuildMode.getInstance().getConfig().getString("messages.prefix"));
    }

    public static String getNoPermission() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.no-permission"));
    }

    public static String getCommandUsage() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.command-usage"));
    }

    public static String getPlayerOnlyCommand() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.player-only-command"));
    }

    public static String getReloaded() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.reloaded"));
    }

    public static String getBuildEnabled() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.build-enabled"));
    }

    public static String getBuildDisabled() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.build-disabled"));
    }

    public static String getBuildEnabledPlayer() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.build-enabled-player"));
    }

    public static String getBuildDisabledPlayer() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.build-disabled-player"));
    }

    public static String getPlayerNotOnline() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.player-not-online"));
    }

    public static String getBuildCurrentlyDisabled() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.build-currently-disabled"));
    }

    public static String getWorldEditDisabled() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.worldedit-disabled"));
    }

    public static String getVersion() {
        return StringUtils.color(getPrefix() + BuildMode.getInstance().getConfig().getString("messages.version"));
    }

    public static String[] getHelp() {
        return StringUtils.color(BuildMode.getInstance().getConfig().getStringList("messages.help"));
    }

}
