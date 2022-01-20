package com.christmas.tsprotect;

import com.christmas.tsprotect.commands.editblacklist;
import com.christmas.tsprotect.events.BlockModifyEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class TSProtect extends JavaPlugin {
    String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.RESET + "\uE004" + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE;

    List<String> stringmaterials = new ArrayList<>();
    List<Material> blacklists = new ArrayList<>();
    private static  TSProtect plugin = null;
    FileConfiguration config = null;
    @Override
    public void onEnable() {
        plugin = this;
        // yes sus
        config = this.getConfig();
        this.saveDefaultConfig();
        stringmaterials = config.getStringList("config.blacklist");
        for(String s : stringmaterials){
            blacklists.add(Material.getMaterial(s.toUpperCase()));
        }

        getServer().getPluginManager().registerEvents(new BlockModifyEvent(), this);
        getCommand("editblacklist").setExecutor(new editblacklist());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public  FileConfiguration getmainConfig(){
        return config;
    }
    public static TSProtect getPlugin(){
        return plugin;
    }
    public List<Material> getBlacklist(){
        return blacklists;
    }
    public  String getPrefix(){
        return  prefix;
    }
}
