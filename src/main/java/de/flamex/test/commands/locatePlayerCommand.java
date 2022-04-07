package de.flamex.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.flamex.test.utilities.errorMessages;
import org.bukkit.entity.Player;

public class locatePlayerCommand implements CommandExecutor {

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

        Player player = Bukkit.getServer().getPlayer(args[0]);
        if (player == null) {
            errorMessages.custom("Player is not online");
            return true;
        }

        Location location = player.getLocation();
        sender.sendMessage(player.getDisplayName() + " is located at " + ChatColor.GREEN + "[" + Math.round(location.getX()) + ", " + Math.round(location.getY()) + ", " + Math.round(location.getZ()) + "]");

        return true;
    }
}
