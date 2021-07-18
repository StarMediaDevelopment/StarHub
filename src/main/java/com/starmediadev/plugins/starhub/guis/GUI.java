package com.starmediadev.plugins.starhub.guis;

import com.starmediadev.plugins.starhub.StarHub;
import com.starmediadev.plugins.starhub.util.GuiUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUI {

    public static Inventory Inv;
    private StarHub main;
    private static GuiUtil gui;

    public GUI(String GUI, Player player, StarHub main, int size, String title) {
        Inv = Bukkit.createInventory(null, size, title);
        this.main = main;
        this.gui = new GuiUtil(main);
        gui.generateItems(Inv, GUI);

        player.openInventory(Inv);


    }
}
