package me.hostify.buildmode.listeners;

import me.hostify.buildmode.BuildMode;
import me.hostify.buildmode.utils.ConfigUtils;
import me.hostify.buildmode.utils.MessageUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    private BuildMode plugin;

    public PlayerListener(BuildMode plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission(plugin.usePermission)) {
            if (ConfigUtils.getEnableOnJoin()) {
                plugin.toggledPlayers.add(event.getPlayer().getUniqueId());
            }
        }
    }

    @EventHandler
    public void onWorldEdit(PlayerCommandPreprocessEvent event) {
        if (ConfigUtils.getDisableWorldEdit()) {
            if (event.getMessage().startsWith("//")) {
                event.getPlayer().sendMessage(MessageUtils.getWorldEditDisabled());
                event.setCancelled(true);
            }
        }
    }

}
