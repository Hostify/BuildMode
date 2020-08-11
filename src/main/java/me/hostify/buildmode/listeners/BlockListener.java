package me.hostify.buildmode.listeners;

import me.hostify.buildmode.BuildMode;
import me.hostify.buildmode.utils.MessageUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

    private BuildMode plugin;

    public BlockListener(BuildMode plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!this.plugin.toggledPlayers.contains(event.getPlayer().getUniqueId())) {
            return;
        }
        event.setCancelled(true);
        event.getPlayer().sendMessage(MessageUtils.getBuildCurrentlyDisabled());
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!this.plugin.toggledPlayers.contains(event.getPlayer().getUniqueId())) {
            return;
        }
        event.setCancelled(true);
        event.getPlayer().sendMessage(MessageUtils.getBuildCurrentlyDisabled());
    }

}
