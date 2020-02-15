package me.Rokaz.InteractiveBlocks.core.cmd;

import me.Rokaz.InteractiveBlocks.core.cmd.config.CommandConfig;
import me.Rokaz.InteractiveBlocks.core.cmd.subcmd.ISubCommand;

import java.util.List;

public abstract class Command implements ICommand {
    private String name;
    private String permission;
    private String description;
    private CommandConfig config;
    private List<ISubCommand> subcommands;
    public Command(String permission, String name,String description,CommandConfig config, List<ISubCommand> subcommands) {
        this.name = name;
        this.permission = permission;
        this.description = description;
        this.subcommands = subcommands;
        this.config = config;
    }
    public CommandConfig getCommandConfig() {
        return this.config;
    }
    public String getName() {
        return this.name;
    }
    public String getPermission() {
        return this.permission;
    }
    public String getDescription() {
        return this.description;
    }
    public List<ISubCommand> getSubCommands() {
        return this.subcommands;
    }

}
