package me.Rokaz.InteractiveBlocks.core.blocks.checkers;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class BlockProtector implements Listener {
    private Plugin pl;
    public BlockProtector(Plugin pl) {
        this.pl = pl;
    }
    @EventHandler
    public void blockbreak(BlockBreakEvent e) {
        if (InteractiveBlocks.bm.getBlockConfig().containsBlock(e.getBlock())) {e.setCancelled(true);}
    }
}
