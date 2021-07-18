package com.starmediadev.plugins.starhub.commands;

import com.starmediadev.plugins.starhub.StarHub;
import com.starmediadev.plugins.starhub.guis.GUI;
import com.starmediadev.plugins.starhub.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class GUICommands implements CommandExecutor {

    private StarHub main;

    public GUICommands(StarHub main) {
        this.main = main;
        Bukkit.getPluginCommand("open").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                String open = args[0];
                main.getConfig().getConfigurationSection("GUIS").getKeys(false).forEach(gui -> {
                    if (main.getConfig().getString("GUIS." + gui + ".Opener").equalsIgnoreCase(open)) {
                        Util.sendMsg("Opening GUI", player);
                        new GUI(gui, player, main, main.getConfig().getInt("GUIS." + gui + ".Size"), ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("GUIS." + gui + ".Title")));
                    }
                });
            }
            return true;
        }
        return false;
    }
}
