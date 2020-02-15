package me.Rokaz.InteractiveBlocks.core.blocks.cmd.subcmds;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import me.Rokaz.InteractiveBlocks.core.cmd.config.CommandConfig;
import me.Rokaz.InteractiveBlocks.core.cmd.subcmd.SubCommand;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Set;

public class RemoveBlock extends SubCommand {
    public RemoveBlock() {
        super("removeblock", "InteractiveBlocks.iblocks.removeblock", "Removes an interactive block",new CommandConfig("iblocks.removeblock"));
        addDefaults();
    }
    private void addDefaults() {
        getCommandConfig().addDefault("error_block_is_air","&c&lError► &4You're not looking at a block");
        getCommandConfig().addDefault("error_not_interactive_block","&c&lError► &4The block you're looking is not an interactive block");
        getCommandConfig().addDefault("successful_remove_block","&a&lSuccessfully removed an interactive block");
        if (!getCommandConfig().setup()) {
            getCommandConfig().setupKeys();
        }
    }
    public void run(Player p, String[] args) {
        Block b = p.getTargetBlock((Set<Material>) null,5);
        if (b == null) {
            p.sendMessage(getCommandConfig().getMessage("error_block_is_air"));
            return;
        }
        if (!InteractiveBlocks.bm.getBlockConfig().containsBlock(b)) {
            p.sendMessage(getCommandConfig().getMessage("error_not_interactive_block"));
            return;
        }
        InteractiveBlocks.bm.getBlockConfig().removeBlock(b);
        p.sendMessage(getCommandConfig().getMessage("successful_remove_block"));
    }
}
