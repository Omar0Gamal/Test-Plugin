package me.plugintest;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static String title;
    private static String subTitle;
    private static Integer time;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Events(this), this);
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
    public int getTime(){
        time = getPlugin(Main.class).getConfig().getInt("title.time");
        return time;
    }

    public void sendToProxy(Player p, String title) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerJoined");
        out.writeUTF(p.getName());
        out.writeUTF(title);

        p.sendPluginMessage(this, "BungeeCord", out.toByteArray());
    }

}
