package de.flamex.test.events;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.text.SimpleDateFormat;

public class onLogin implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {

        Player player = event.getPlayer();

        if (player.isBanned()) {
            BanEntry ban = Bukkit.getServer().getBanList(BanList.Type.NAME).getBanEntry(player.getName());

            String source = ban.getSource();
            String expiration;
            String reason = ban.getReason();

            if (ban.getExpiration() == null) {
                expiration = "Permament";
            } else {
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:HH:ss");
                expiration = format.format(ban.getExpiration());
            }

            event.setKickMessage(
                    "\n" +
                    ChatColor.DARK_RED + "You are banned!\n" +
                    "\n" +
                    ChatColor.RED + "Issued by: " + ChatColor.GRAY + source + "\n" +
                    ChatColor.RED + "Expires at: " + ChatColor.GRAY + expiration + "\n" +
                    ChatColor.RED + "Ban reason: " + ChatColor.GRAY + reason
            );
        } else {
            /**
             * Used for testing
             *
             * Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(event.getPlayer().getName(), "Hacking", new Date(new Date().getTime() + (1000 * 60 * 60 * 48)), "Flamex_dev");
             */
        }
    }
}
