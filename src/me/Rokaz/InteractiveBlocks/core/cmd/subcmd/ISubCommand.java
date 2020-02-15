package me.Rokaz.InteractiveBlocks.core.cmd.subcmd;

import me.Rokaz.InteractiveBlocks.core.cmd.config.CommandConfig;
import org.bukkit.entity.Player;

public interface ISubCommand {
    public abstract String getName();
    public abstract void run(Player p, String[] args);
    public abstract String getPermission();
    public abstract String getDescription();
    public abstract CommandConfig getCommandConfig();
}
