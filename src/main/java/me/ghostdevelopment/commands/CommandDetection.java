package me.ghostdevelopment.commands;

import me.ghostdevelopment.VanteyFreeze;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandDetection implements CommandExecutor {

    VanteyFreeze plugin;
    public CommandDetection(VanteyFreeze plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {




        return true;
    }
}
