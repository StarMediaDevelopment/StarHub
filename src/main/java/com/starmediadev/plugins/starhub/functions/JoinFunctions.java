package com.starmediadev.plugins.starhub.functions;

import com.starmediadev.plugins.starhub.StarHub;
import org.bukkit.ChatColor;
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

    public void giveItems(Player user, String path) {
        List<String> items = main.getConfig().getStringList(path);
        if (items.get(0).equalsIgnoreCase("none")) {
            return;
        }
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
            int numberOfItems = Integer.parseInt(giveItems[4]);


            final ItemStack itemStack = new ItemStack(material, numberOfItems);
            final ItemMeta meta = itemStack.getItemMeta();

            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            meta.setLore(formatLore);
            itemStack.setItemMeta(meta);
            user.getInventory().setItem(slot, itemStack);

        }
    }

}
