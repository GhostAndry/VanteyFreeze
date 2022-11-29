package me.ghostdevelopment;

import me.ghostdevelopment.commands.CommandDetection;
import me.ghostdevelopment.commands.CommandFreeze;
import me.ghostdevelopment.commands.CommandUnfreeze;
import me.ghostdevelopment.listener.PlayerMoveListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class VanteyFreeze extends JavaPlugin{

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.LIGHT_PURPLE+"VanteyFreeze by GhostAndry");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Register commands
        registerCommands();

        // Register events
        registerEvent();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    void registerCommands(){
        getCommand("freeze").setExecutor(new CommandFreeze(this));
        getCommand("unfreeze").setExecutor(new CommandUnfreeze(this));
        getCommand("detection").setExecutor(new CommandDetection(this));
    }
    void registerEvent(){
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(this),this);
    }

}
