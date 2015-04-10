package nl.galaxias.dangerousenderpearls;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Galaxias on 10-04-15 (16:34).
 * This file is part of DangerousEnderPearls in the package nl.galaxias.dangerousenderpearls.
 */
public class DangerousEnderPearls extends JavaPlugin {
    private static Plugin plugin;
    FileConfiguration config = getConfig();

    public void onEnable() {
        plugin = this;

        registerEvents(this, new ProjectileHitListener());

        config.addDefault("damage", 1.0);

        config.options().copyDefaults(true);
        saveConfig();
    }

    public void onDisable() {
        plugin = null;
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}