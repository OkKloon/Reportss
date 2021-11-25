package me.powerbutton.reports;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public final class Reports extends JavaPlugin {
    private static Reports instance;
    public static Reports getInstance() {
        return instance;
    }
    @Override
    public void onEnable(){
        instance = this;
        Bukkit.getLogger().info("Reporti nāk augšā!!!");
        Bukkit.getScheduler().runTaskTimerAsynchronously(Reports.getInstance(), () -> {
            Bukkit.broadcastMessage(ChatColor.GREEN + "Ja kāds pārkāpj spēles noteikumus, raksti čatā '/report <spēlētāja vārds>'!");
        }, 10, 6000);
        this.getCommand("report").setExecutor(new CMD());
        Bukkit.getLogger().info("Reporti ir pabeigti iet augšā!!!");
    }

    @Override
    public void onDisable(){
        // Plugin shutdown logic
    }

}


