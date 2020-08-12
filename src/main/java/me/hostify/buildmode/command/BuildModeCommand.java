package me.hostify.buildmode.command;

import me.hostify.buildmode.BuildMode;
import me.hostify.buildmode.utils.MessageUtils;
import me.hostify.buildmode.utils.ReloadUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildModeCommand implements CommandExecutor {

    private BuildMode plugin;

    public BuildModeCommand(BuildMode plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String noPermission = MessageUtils.getNoPermission();
        if (!sender.hasPermission(plugin.usePermission)) {
            sender.sendMessage(noPermission);
            return true;
        }
        if (args.length == 0) {
            toggleMode(sender);
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(MessageUtils.getHelp());
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission(plugin.reloadPermission)) {
                    reload(sender);
                } else {
                    sender.sendMessage(noPermission);
                }
            } else if (args[0].equalsIgnoreCase("version")) {
                sender.sendMessage(MessageUtils.getVersion().replace("%VERSION%", plugin.getDescription().getVersion()));
            } else {
                if (sender.hasPermission(plugin.useOthersPermission)) {
                    Player receiver = Bukkit.getPlayer(args[0]);
                    if (receiver != null) {
                        toggleMode(sender, receiver);
                    } else {
                        sender.sendMessage(MessageUtils.getPlayerNotOnline().replace("%PLAYER%", args[0]));
                    }
                } else {
                    sender.sendMessage(noPermission);
                }
            }
        } else {
            sender.sendMessage(MessageUtils.getCommandUsage());
        }
        return true;
    }

    private void playerOnly(CommandSender sender) {
        sender.sendMessage(MessageUtils.getPlayerOnlyCommand());
    }

    private void reload(CommandSender sender) {
        ReloadUtil.reloadConfig();
        sender.sendMessage(MessageUtils.getReloaded());
    }

    private void toggleMode(CommandSender sender) {
        if (!(sender instanceof Player)) {
            playerOnly(sender);
            return;
        }
        Player player = ((Player) sender);
        boolean toggled = plugin.toggledPlayers.contains(player.getUniqueId());
        if (toggled) {
            plugin.toggledPlayers.remove(player.getUniqueId());
            player.sendMessage(MessageUtils.getBuildEnabled());
        } else {
            plugin.toggledPlayers.add(player.getUniqueId());
            player.sendMessage(MessageUtils.getBuildDisabled());
        }
    }

    private void toggleMode(CommandSender sender, Player receiver) {
        boolean toggled = plugin.toggledPlayers.contains(receiver.getUniqueId());
        if (toggled) {
            plugin.toggledPlayers.remove(receiver.getUniqueId());
            sender.sendMessage(MessageUtils.getBuildEnabledPlayer().replace("%PLAYER%", receiver.getName()));
        } else {
            plugin.toggledPlayers.add(receiver.getUniqueId());
            sender.sendMessage(MessageUtils.getBuildDisabledPlayer().replace("%PLAYER%", receiver.getName()));
        }
    }

}
