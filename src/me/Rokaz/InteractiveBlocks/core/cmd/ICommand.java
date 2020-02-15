package me.Rokaz.InteractiveBlocks.core.cmd;

import me.Rokaz.InteractiveBlocks.core.cmd.config.CommandConfig;
import me.Rokaz.InteractiveBlocks.core.cmd.subcmd.ISubCommand;
import org.bukkit.entity.Player;

import java.util.List;

public abstract interface ICommand {
    public abstract String getName();
    public abstract void run(Player p, String[] args);
    public abstract String getPermission();
    public abstract String getDescription();
    public abstract List<ISubCommand> getSubCommands();
    public abstract CommandConfig getCommandConfig();
}
