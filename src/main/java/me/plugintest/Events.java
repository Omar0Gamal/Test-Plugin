package me.plugintest;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.getPlayer().sendTitle(Main.getInstance().getTitle(), Main.getInstance().getSubTitle(),1,Main.getInstance().getTime(),1);
        Main.getInstance().sendToProxy(e.getPlayer(),Main.getInstance().getTitle());
    }

}
