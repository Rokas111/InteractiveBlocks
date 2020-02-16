package me.Rokaz.InteractiveBlocks.core;

import me.Rokaz.InteractiveBlocks.core.blocks.BlockManager;
import me.Rokaz.InteractiveBlocks.core.cmd.CommandManager;
import me.Rokaz.InteractiveBlocks.core.cmd.ICommand;
import me.Rokaz.InteractiveBlocks.core.config.ConfigManager;
import metrics.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InteractiveBlocks extends JavaPlugin {
    public static final String PLUGIN_FOLDER = "InteractiveBlocks";
    public static ConfigManager cm;
    public static CommandManager cc;
    public static BlockManager bm;
    public void onEnable() {
        cm = new ConfigManager(this);
        cc = new CommandManager(this);
        bm = new BlockManager(this);
        Metrics m = new Metrics(this,6516);
        bm.initialize();
    }
    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {
        Player p = (Player)s;
        ICommand cmd = cc.getCommand(command.getName().toLowerCase());
        if (cmd != null) {
            if (args != null &&args.length >= 1 && !cmd.getSubCommands().isEmpty() && !cmd.getSubCommands().stream().filter(subcommand -> subcommand.getName().equals(args[0])).collect(Collectors.toList()).isEmpty() ) {
                if (!p.getPlayer().hasPermission( cc.getSubCommand(cmd,args[0]).getPermission())) {
                    p.sendMessage(ChatColor.RED + "You don't have the permission to execute this sub-command");
                    return true;
                }
                cc.getSubCommand(cmd,args[0]).run(p, Arrays.asList(args).subList(1,args.length).toArray(new String[0]));
                return true;
            }
            if (!p.getPlayer().hasPermission(cmd.getPermission())) {
                p.sendMessage(ChatColor.RED + "You don't have the permission to execute this command");
                return true;
            }
            cmd.run(p, args);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> suggestions = new ArrayList<>();
        List<String> completions = new ArrayList<>();
        cc.getCommands().forEach(cmd -> {
            if (command.getName().equals(cmd.getName())) {
                cmd.getSubCommands().forEach(subcmd -> {
                    completions.add(subcmd.getName());
                });
            } else {
                completions.add(cmd.getName());
            }
        });
        StringUtil.copyPartialMatches(args[0], completions, suggestions);
        Collections.sort(suggestions);
        return suggestions;
    }

}
