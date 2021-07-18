package com.starmediadev.plugins.starhub.commands;

import com.starmediadev.plugins.starhub.StarHub;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    private StarHub main;

    public Commands(StarHub main) {
        this.main = main;
        Bukkit.getPluginCommand("spawn").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location spawn = new Location(Bukkit.getWorld(main.getConfig().getString("Spawn.WORLD")),
                    main.getConfig().getDouble("Spawn.X"), main.getConfig().getDouble("Spawn.Y"),
                    main.getConfig().getDouble("Spawn.Z"), main.getConfig().getInt("Spawn.YAW"),
                    main.getConfig().getInt("Spawn.PITCH"));
            player.teleport(spawn);
            return true;
        }
        return false;
    }
}
