package com.starmediadev.plugins.starhub.functions;

import com.starmediadev.plugins.starhub.StarHub;
import com.starmediadev.plugins.starhub.util.Util;
import org.bukkit.entity.Player;

import java.util.List;

public class MessageFunctions {

    private StarHub main;

    public MessageFunctions(StarHub main) {
        this.main = main;
    }

    public void sendMessages(Player user, String config) {
        List<String> messages = main.getConfig().getStringList(config);
        for (String message : messages) {
            Util.sendMsg(message, user);
        }
    }

}
