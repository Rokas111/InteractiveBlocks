package me.Rokaz.InteractiveBlocks.core.blocks;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import me.Rokaz.InteractiveBlocks.core.blocks.cmd.IBlocks;
import me.Rokaz.InteractiveBlocks.core.blocks.cmd.subcmds.AddBlock;
import me.Rokaz.InteractiveBlocks.core.blocks.cmd.subcmds.AddCommand;
import me.Rokaz.InteractiveBlocks.core.blocks.cmd.subcmds.Reload;
import me.Rokaz.InteractiveBlocks.core.blocks.cmd.subcmds.RemoveBlock;
import me.Rokaz.InteractiveBlocks.core.blocks.config.BlockConfig;
import me.Rokaz.InteractiveBlocks.core.blocks.checkers.BlockChecker;
import me.Rokaz.InteractiveBlocks.core.blocks.checkers.BlockProtector;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

public class BlockManager {
    private Plugin pl;
    private BlockConfig bc;
    public BlockManager(Plugin pl) {
        this.pl = pl;
    }
    public void initialize() {
        registerConfigs();
        registerCommands();
        pl.getServer().getPluginManager().registerEvents(new BlockChecker(pl), pl);
        pl.getServer().getPluginManager().registerEvents(new BlockProtector(pl), pl);
    }
    private void registerConfigs() {
        InteractiveBlocks.cm.registerConfig(new BlockConfig());
        bc = (BlockConfig) InteractiveBlocks.cm.getYaml("blocks");
    }
    private void registerCommands() {InteractiveBlocks.cc.registerCommand(new IBlocks(Arrays.asList(new Reload(),new AddCommand(),new RemoveBlock(),new AddBlock())));}
    public BlockConfig getBlockConfig() {
        return this.bc;
    }
}
