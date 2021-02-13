package me.plugintest;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static String title;
    private static String subTitle;
    private static Integer time;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static String getTitle(){
        title = ChatColor.translateAlternateColorCodes('&',getPlugin(Main.class).getConfig().getString("title.title"));
        return title;
    }
    public static String getSubTitle(){
        subTitle = ChatColor.translateAlternateColorCodes('&',getPlugin(Main.class).getConfig().getString("title.subtitle"));
        return subTitle;
    }
    public static int getTime(){
        time = getPlugin(Main.class).getConfig().getInt("title.time");
        return time;
    }

}
