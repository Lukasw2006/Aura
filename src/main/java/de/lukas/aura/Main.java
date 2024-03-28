package de.lukas.aura;

import de.lukas.aura.command.AuraCommand;
import de.lukas.aura.listeners.PlayerMovement;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {
    public static ArrayList<String> aura = new ArrayList<>();
    public static Main main;

    @Override
    public void onEnable() {
    main = this;
        Bukkit.getPluginManager().registerEvents(new PlayerMovement(), this);
        getCommand("aura").setExecutor(new AuraCommand());
    }

    @Override
    public void onDisable() {

    }

    public static ArrayList<String> getAura() {
        return aura;
    }

    public static Main getMain() {
        return main;
    }
}
