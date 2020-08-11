package me.hostify.buildmode.utils;

import me.hostify.buildmode.BuildMode;

public class ReloadUtil {

    public static void reloadConfig() {
        BuildMode.getInstance().reloadConfig();
    }

}
