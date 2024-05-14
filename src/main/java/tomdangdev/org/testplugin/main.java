package tomdangdev.org.testplugin;

import org.bukkit.plugin.java.JavaPlugin;
import tomdangdev.org.testplugin.items.Hyperion;
import tomdangdev.org.testplugin.mobs.ghost;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("Hyperion").setExecutor(new Hyperion());
        getCommand("Ghost").setExecutor(new ghost(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
