package me.hostify.buildmode.utils;

import me.hostify.buildmode.BuildMode;

public class ConfigUtils {

    public static boolean getEnableOnJoin() {
        return BuildMode.getInstance().getConfig().getBoolean("settings.enable-on-join");
    }

    public static boolean getDisableWorldEdit() {
        return BuildMode.getInstance().getConfig().getBoolean("settings.disable-worldedit");
    }

}
