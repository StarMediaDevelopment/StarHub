package com.starmediadev.plugins.starhub.features;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreBoard {

    public ScoreBoard() {

    }

    public void setScoreBoard() {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("ServerName","Dummy","Test Server");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

}
