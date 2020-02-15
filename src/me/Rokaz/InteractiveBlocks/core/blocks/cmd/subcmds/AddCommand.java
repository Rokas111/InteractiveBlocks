package me.Rokaz.InteractiveBlocks.core.blocks.cmd.subcmds;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import me.Rokaz.InteractiveBlocks.core.cmd.config.CommandConfig;
import me.Rokaz.InteractiveBlocks.core.cmd.subcmd.SubCommand;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Set;

public class AddCommand extends SubCommand {
    public AddCommand() {
        super("addcommand", "InteractiveBlocks.iblocks.addcommand", "Adds a command to an interactive block",new CommandConfig("iblocks.addcommand"));
        addDefaults();
    }
    private void addDefaults() {
        getCommandConfig().addDefault("error_block_is_air","&c&lError► &4You're not looking at a block");
        getCommandConfig().addDefault("error_not_interactive_block","&c&lError► &4The block you're looking is not an interactive block");
        getCommandConfig().addDefault("invalid_add_command_usage","&c&lError► &4Wrong command usage. Please use this format /iblocks addcommand <Command>");
        getCommandConfig().addDefault("successful_add_command","&a&lSuccessfully added a command to an interactive block");
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
        if (args == null || args.length == 0) {
            p.sendMessage(getCommandConfig().getMessage("invalid_add_command_usage"));
            return;
        }
        InteractiveBlocks.bm.getBlockConfig().addCommand(b,args[0],args.length > 1? Arrays.asList(args).subList(1,args.length):null);
        p.sendMessage(getCommandConfig().getMessage("successful_add_command"));
    }
}
