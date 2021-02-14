package me.plugintest;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private String title;
    private String subTitle;
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public String getTitle(){
        title = ChatColor.translateAlternateColorCodes('&',getPlugin(Main.class).getConfig().getString("title.title"));
        return title;
    }
    public String getSubTitle(){
        subTitle = ChatColor.translateAlternateColorCodes('&',getPlugin(Main.class).getConfig().getString("title.subtitle"));
        return subTitle;
    }
    public static Main getInstance() {
        return instance;
    }

    public void sendToProxy(Player p, String title) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("PlayerJoined");
                out.writeUTF(p.getName());
                out.writeUTF(title);
                p.getServer().sendPluginMessage(instance,"BungeeCord", out.toByteArray());
            }
        },20*5);
    }

}
