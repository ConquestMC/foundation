package com.conquestmc.foundation.bungee.listeners;


import com.conquestmc.foundation.API;
import com.conquestmc.foundation.CorePlayer;
import com.conquestmc.foundation.CorePlayerManager;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PostLoginListener implements Listener {
    @EventHandler
    public void onPlayerLogin(PostLoginEvent event) {
        CorePlayerManager manager = (CorePlayerManager) API.getUserManager();
        CorePlayer user = manager.getUserDataDriver().findById(event.getPlayer().getUniqueId());
        if (user == null) {
            user = new CorePlayer(event.getPlayer().getUniqueId());
            manager.getUserDataDriver().create(user);
        }
        System.out.println("Updating user");
        user.setOnline(true);
        user.update();
        user.setName(event.getPlayer().getName());
        manager.getUsers().add(user);
    }
}