package tomdangdev.org.testplugin;

import org.bukkit.plugin.java.JavaPlugin;
import tomdangdev.org.testplugin.items.Hyperion;

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
