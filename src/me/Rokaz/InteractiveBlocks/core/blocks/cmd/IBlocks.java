package me.Rokaz.InteractiveBlocks.core.blocks.cmd;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import me.Rokaz.InteractiveBlocks.core.cmd.Command;
import me.Rokaz.InteractiveBlocks.core.cmd.subcmd.ISubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class IBlocks extends Command {
    public IBlocks(List<ISubCommand> subcommands) {
        super("InteractiveBlocks.iblocks", "iblocks","The main command of InteractiveBlocks",null, subcommands);
    }
    public void run(Player p, String[] args) {
        p.getPlayer().sendMessage(ChatColor.RED+"["+ChatColor.WHITE+"InteractiveBlocks"+ChatColor.RED+"]" + ChatColor.YELLOW + " Commands:");
        InteractiveBlocks.cc.getCommands().forEach(cmd -> {
            p.getPlayer().sendMessage(ChatColor.GREEN+"/" + cmd.getName() + " " + ChatColor.GRAY +cmd.getDescription());
            cmd.getSubCommands().forEach(subcmd -> p.getPlayer().sendMessage(ChatColor.GREEN+"/" +cmd.getName()+ " "+subcmd.getName() + " " + ChatColor.GRAY +subcmd.getDescription()));
        });
    }
}
