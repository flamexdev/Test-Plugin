package de.flamex.test.commands;

import de.flamex.test.utilities.errorMessages;
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

        errorMessages errorMessages = new errorMessages(sender);

        if (!sender.isOp()) {
            errorMessages.missingPermissions();
            return true;
        }

        if (args.length == 0) {
            errorMessages.invalidUsage(command);
            return true;
        }

        OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);
        if (!target.isBanned()) {
            errorMessages.custom(target.getName() + " is not banned");
        } else {
            Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(target.getName());
            sender.sendMessage(ChatColor.GREEN + target.getName() + " got unbanned");
        }

        return true;
    }
}
