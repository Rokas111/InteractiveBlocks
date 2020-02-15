package me.Rokaz.InteractiveBlocks.core.blocks.cmd.subcmds;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import me.Rokaz.InteractiveBlocks.core.cmd.config.CommandConfig;
import me.Rokaz.InteractiveBlocks.core.cmd.subcmd.SubCommand;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.Set;

public class AddBlock extends SubCommand {
    public AddBlock() {
        super("addblock", "InteractiveBlocks.iblocks.addblock", "Makes a block interactive",new CommandConfig("iblocks.addblock"));
        addDefaults();
    }
    private void addDefaults() {
        getCommandConfig().addDefault("error_block_is_air","&c&lError► &4You're not looking at a block");
        getCommandConfig().addDefault("error_interactive_block_already","&c&lError► &4The block you're looking at is already an interactive block");
        getCommandConfig().addDefault("successful_add_block","&a&lSuccessfully added an interactive block");
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
        if (InteractiveBlocks.bm.getBlockConfig().containsBlock(b)) {
            p.sendMessage(getCommandConfig().getMessage("error_interactive_block_already"));
            return;
        }
        InteractiveBlocks.bm.getBlockConfig().addBlock(b, Collections.EMPTY_LIST);
        p.sendMessage(getCommandConfig().getMessage("successful_add_block"));
    }
}
