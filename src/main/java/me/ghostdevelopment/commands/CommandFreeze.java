package me.ghostdevelopment.commands;

import me.ghostdevelopment.Manager;
import me.ghostdevelopment.Utils;
import me.ghostdevelopment.VanteyFreeze;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFreeze implements CommandExecutor {

    VanteyFreeze plugin;
    public CommandFreeze(VanteyFreeze plugin){this.plugin=plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(Utils.Color(plugin.getConfig().getString("onlyPlayer")));
            return false;
        }

        if(!(sender.hasPermission("vanteyfreeze.freeze")||sender.hasPermission("vanteyfreeze.*")|| sender.hasPermission("*"))){
            sender.sendMessage(Utils.Color(plugin.getConfig().getString("noPerms")));
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage(Utils.Color(plugin.getConfig().getString("freeze.usage")));
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if(target==null){
            sender.sendMessage(Utils.Color(plugin.getConfig().getString("freeze.player-not-found")).replace("%player%", target.getName()));
            return false;
        }

        if(args.length == 1){

            if(target.hasPermission("vanteyfreeze.staff")){
                sender.sendMessage(Utils.Color(plugin.getConfig().getString("noPerms-player").replace("%player%", target.getName())));
            }else {
                if(target == sender){
                    sender.sendMessage(Utils.Color(plugin.getConfig().getString("freeze.no-self")));
                    return false;
                }
                if(Manager.freezeManager.contains(target)){
                    sender.sendMessage(Utils.Color(plugin.getConfig().getString("freeze.already-frozen").replace("%player%", target.getName())));
                }else {
                    Manager.frozenPlayerLoc = target.getLocation();
                    Manager.freezeManager.add(target);
                    sender.sendMessage(Utils.Color(plugin.getConfig().getString("freeze.player-frozen").replace("%player%", target.getName())));
                }
            }
        }
        return true;
    }
}
