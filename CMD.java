package me.powerbutton.reports;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Sound;

public class CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (cmd.getName().equalsIgnoreCase("report") && args.length == 1) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                Player player = Bukkit.getPlayerExact(args[0]);
                if (player != null) {
                    sendReportToOps(player, p);
                } else {
                    sender.sendMessage(CommonStrings.DOESNT_EXIST);
                }
            }
        }
        return false;
    }
    public void sendReportToOps(Player player, Player sender) {
        for(Player players : Bukkit.getServer().getOnlinePlayers()) {
            if(players.isOp()) {
             players.sendMessage(ChatColor.RED + "Jauns paziņojums: Spēlētāja vārds: " + player.getName());
                Bukkit.getScheduler().runTaskLater(Reports.getInstance(), () -> {
                    players.playSound(players.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 0.5f);
                }, 1);
                Bukkit.getScheduler().runTaskLater(Reports.getInstance(), () -> {
                    players.playSound(players.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 0.5f);
                }, 6);
                Bukkit.getScheduler().runTaskLater(Reports.getInstance(), () -> {
                    players.playSound(players.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 0.5f);
                }, 11);
                players.sendTitle(ChatColor.RED + player.getName() + ": paziņojums", "no: " + sender.getName(), 0, 100, 0);

            }
        }
    }
}
