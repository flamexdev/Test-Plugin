package de.flamex.test.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class unbanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Is OP
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "Missing permissions");
            return true;
        }

        // Username given
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Invalid format. Usage: " + command.getUsage());
            return true;
        }

        OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);
        if (!target.isBanned()) {
            sender.sendMessage(ChatColor.RED + target.getName() + " is not banned");
        } else {
            Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(target.getName());
            sender.sendMessage(ChatColor.GREEN + target.getName() + " got unbanned");
        }

        return true;
    }
}
