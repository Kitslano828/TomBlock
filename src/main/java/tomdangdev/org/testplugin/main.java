package tomdangdev.org.testplugin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("Hyperion").setExecutor(new Hyperion());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
