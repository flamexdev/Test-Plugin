package de.flamex.test;

import org.bukkit.plugin.java.JavaPlugin;
import de.flamex.test.commands.*;

public final class Test extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("unban").setExecutor(new unbanCommand());
    }

    @Override
    public void onDisable() { }
}
