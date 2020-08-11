package me.hostify.buildmode;

import me.hostify.buildmode.command.BuildModeCommand;
import me.hostify.buildmode.listeners.BlockListener;
import me.hostify.buildmode.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class BuildMode extends JavaPlugin {

    public final String usePermission = "buildmode.use";
    public final String useOthersPermission = "buildmode.use.others";
    public final String reloadPermission = "buildmode.reload";
    public final BlockListener blockListener = new BlockListener(this);
    public final PlayerListener playerListener = new PlayerListener(this);
    public static Set<UUID> toggledPlayers = new HashSet<>();
    public static BuildMode instance;

    public static BuildMode getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.registerCommands();
        this.registerEvents();
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void saveDefaultConfig() {
        super.saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void registerCommands() {
        this.getCommand("buildmode").setExecutor(new BuildModeCommand(this));
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(this.blockListener, this);
        Bukkit.getPluginManager().registerEvents(this.playerListener, this);
    }

}
