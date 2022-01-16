package com.christmas.tsprotect.commands;

import com.christmas.tsprotect.TSProtect;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class editblacklist implements CommandExecutor {
    TSProtect mainplugin = TSProtect.getPlugin();
    FileConfiguration config = mainplugin.getmainConfig();
    String pf = mainplugin.getPrefix();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("utility.builder.editblacklist")){ // /editblacklist add/remove material
                if(args.length > 1 ){
                    if(args[0].equals("add")){
                        if(Material.getMaterial(args[1]) != null){
                            config.addDefault("config.blacklist", args[1]);
                        }
                    }else if(args[0].equals("remove")){
                        if(config.getList("config.blacklist").contains(args[1])){
                            config.set("config.blacklist", args[1]);
                        }else{
                            p.sendMessage(pf + ChatColor.RED + "That material isn't in the blacklist!");
                        }
                    }else{
                        p.sendMessage(pf + ChatColor.RED + "Invalid syntax. Correct usage: /editblacklist <add/remove> material");
                    }
                }else{
                    p.sendMessage(pf + ChatColor.RED + "Invalid syntax. Correct usage: /editblacklist <add/remove> material");
                }
            }else{
                p.sendMessage(pf + ChatColor.RED + "You don't have permissions to run this command!");
            }
        }
        return true;
    }
}
