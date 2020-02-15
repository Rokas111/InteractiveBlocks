package me.Rokaz.InteractiveBlocks.core.blocks.cmd.subcmds;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import me.Rokaz.InteractiveBlocks.core.cmd.config.CommandConfig;
import me.Rokaz.InteractiveBlocks.core.cmd.subcmd.SubCommand;
import org.bukkit.entity.Player;

public class Reload extends SubCommand {
    public Reload() {
        super("reload", "InteractiveBlocks.iblocks.reload", "Reloads all plugin's configs",new CommandConfig("iblocks.reload"));
        addDefaults();
    }
    private void addDefaults() {
        getCommandConfig().addDefault("successful_config_reload","&a&lSuccessfully reloaded all configs");
        if (!getCommandConfig().setup()) {
            getCommandConfig().setupKeys();
        }
    }
    public void run(Player p, String[] args) {
        InteractiveBlocks.cm.reloadAllConfigs();
        p.sendMessage(getCommandConfig().getMessage("successful_config_reload"));
    }
}
