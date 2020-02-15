package me.Rokaz.InteractiveBlocks.core.blocks.config;

import com.google.common.collect.Lists;
import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import me.Rokaz.InteractiveBlocks.core.config.Config;
import me.Rokaz.InteractiveBlocks.core.config.Section;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BlockConfig extends Config {
    public BlockConfig() {
        super("blocks",new Section(InteractiveBlocks.PLUGIN_FOLDER));
        if (!setup()) {
            setupKeys();
        }
    }
    public void setupKeys() {
    }
    public void addBlock(Block b, List<String> commands) {
        getYaml().set(b.getX()+";" + b.getY() + ";" + b.getZ(), commands);
        save();
    }
    public void addCommand(Block b,String command, List<String> args) {
        if (!containsBlock(b)) return;
        List<String> commands = getYaml().getStringList(b.getX()+";" + b.getY() + ";" + b.getZ());
        commands.add(args==null?command:command + " " +String.join(" ",args));
        getYaml().set(b.getX()+";" + b.getY() + ";" + b.getZ(), commands);
        save();
    }
    public boolean containsBlock(Block b) {
        return getYaml().contains(b.getX()+";" + b.getY() + ";" + b.getZ());
    }
    public void removeBlock(Block b) {
        getYaml().set(b.getX()+";" + b.getY() + ";" + b.getZ(),null);
        save();
    }
    public void activateBlock(Player p,Block b) {
        getYaml().getStringList(b.getX()+";" + b.getY() + ";" + b.getZ()).forEach(command -> Bukkit.dispatchCommand(p,command.contains("%player%")?command.replaceAll("%player%",p.getName()):command));
    }


}
