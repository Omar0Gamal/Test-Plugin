package me.plugintest;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    private Main main ;
    public Events(Main main){
        this.main = main;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.getPlayer().sendTitle(main.getTitle(), main.getSubTitle(),1,main.getTime(),1);
        main.sendToProxy(e.getPlayer(),main.getTitle());
    }

}
