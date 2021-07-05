package com.starmediadev.plugins.starhub.functions;

import com.starmediadev.plugins.starhub.StarHub;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class JoinFunctions {

    private StarHub main;

    public JoinFunctions(StarHub main) {
        this.main = main;
    }

    public void giveItems(Player user) {
        List<String> items = main.getConfig().getStringList("Join.Items");
        for (String item : items) {
            String[] giveItems = item.split(";");
            Material material = Material.valueOf(giveItems[0]);
            String name = giveItems[1];
            int slot = Integer.parseInt(giveItems[2]);
            String[] lores = giveItems[3].split(",");
            ArrayList<String> formatLore = new ArrayList<String>();
            for (String lore : lores) {
                formatLore.add(org.bukkit.ChatColor.translateAlternateColorCodes('&', lore));
            }

            final ItemStack itemStack = new ItemStack(material, 1);
            final ItemMeta meta = itemStack.getItemMeta();

            meta.setDisplayName(name);
            meta.setLore(formatLore);
            itemStack.setItemMeta(meta);
            user.getInventory().setItem(slot, itemStack);

        }
    }

}
