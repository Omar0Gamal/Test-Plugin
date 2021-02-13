package me.plugintest;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.getPlayer().sendTitle(Main.getTitle(), Main.getSubTitle(),1,1000,1);
    }
}
