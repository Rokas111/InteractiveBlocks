package me.Rokaz.InteractiveBlocks.core.blocks.checkers;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class BlockChecker implements Listener {
    private HashMap<Player, Block> previous_blocks;
    private Plugin pl;
    public BlockChecker(Plugin pl) {
        this.pl = pl;
        this.previous_blocks = new HashMap<>();
    }
    @EventHandler
    public void checkblock(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
        if ( b == null || b.getType() == Material.AIR || (!previous_blocks.isEmpty()&& previous_blocks.containsKey(p) && previous_blocks.get(p).equals(b))) {return;}
        if (InteractiveBlocks.bm.getBlockConfig().containsBlock(b)) {
            InteractiveBlocks.bm.getBlockConfig().activateBlock(p,b);
        }
        if (previous_blocks.isEmpty()|| !previous_blocks.containsKey(p)) {previous_blocks.put(p, b);} else {previous_blocks.replace(p,b);}
    }
}
