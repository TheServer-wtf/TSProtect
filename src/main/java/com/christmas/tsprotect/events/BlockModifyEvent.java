package com.christmas.tsprotect.events;

import com.christmas.tsprotect.TSProtect;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class BlockModifyEvent implements Listener{

    TSProtect mainplugin = TSProtect.getPlugin();
    List<Material> blacklist = mainplugin.getBlacklist();

    @EventHandler
    public void onBlockMod(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            Material clickedblock = e.getClickedBlock().getType();
            if(blacklist.contains(clickedblock)){
                e.setCancelled(true);
            }
        }
    }
}
