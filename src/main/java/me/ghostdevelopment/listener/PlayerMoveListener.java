package me.ghostdevelopment.listener;

import me.ghostdevelopment.Manager;
import me.ghostdevelopment.VanteyFreeze;
import me.ghostdevelopment.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    VanteyFreeze plugin;
    public PlayerMoveListener(VanteyFreeze plugin){this.plugin=plugin;}

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){

        Player p = event.getPlayer();

        if(!(Manager.freezeManager.contains(p))){
            return;
        }
        if (event.getFrom().getBlockX() != event.getTo().getBlockX() || event.getFrom().getBlockY() != event.getTo().getBlockY() || event.getFrom().getBlockZ() != event.getTo().getBlockZ())
            event.getPlayer().teleport(Manager.frozenPlayerLoc);
            p.sendMessage(Utils.Color(plugin.getConfig().getString("freeze.frozen-message")));
    }

}
