package de.flamex.test.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;

public class errorMessages {
    CommandSender sender;

    public errorMessages(CommandSender commandSender) {
        sender = commandSender;
    }

    public void missingPermissions() {
        sender.sendMessage(ChatColor.RED + "Missing permissions");
    }

    public void invalidUsage(Command command) {
        sender.sendMessage(ChatColor.RED + "Invalid format. Usage: " + command.getUsage());
    }

    public void custom(String error) {
        sender.sendMessage(ChatColor.RED + error);
    }
}
