package com.conquestmc.foundation.bukkit;


import com.conquestmc.foundation.CoreFoundation;
import com.conquestmc.foundation.bukkit.listeners.AsyncPlayerPreLoginListener;
import com.conquestmc.foundation.bukkit.listeners.PlayerLoginListener;
import com.conquestmc.foundation.bukkit.listeners.PlayerQuitListener;
import com.conquestmc.foundation.API;
import com.conquestmc.foundation.player.FPlayer;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitCore extends JavaPlugin {

    @Override
    public void onEnable() {
        API.setFoundation(new CoreFoundation());

        register();
    }

    @Override
    public void onDisable() {
        for (FPlayer player : API.getUserManager().findAll()) {
            player.update();
        }
    }

    private void register() {
        getServer().getPluginManager().registerEvents(new AsyncPlayerPreLoginListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerLoginListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
    }
}
