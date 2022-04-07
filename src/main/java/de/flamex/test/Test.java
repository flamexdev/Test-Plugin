package de.flamex.test;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import de.flamex.test.commands.*;
import de.flamex.test.events.*;

public final class Test extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getCommand("unban").setExecutor(new unbanCommand());
        this.getCommand("lp").setExecutor(new locatePlayerCommand());
        this.getServer().getPluginManager().registerEvents(new onLogin(), this);
    }
}
