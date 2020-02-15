package me.Rokaz.InteractiveBlocks.core.cmd.config;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import me.Rokaz.InteractiveBlocks.core.config.Config;
import me.Rokaz.InteractiveBlocks.core.config.Section;
import org.bukkit.ChatColor;

import java.io.IOException;
import java.util.HashMap;

public class CommandConfig extends Config {
    private HashMap<String,String> messages;
    public CommandConfig(String name) {
        super(name, new Section(new Section(InteractiveBlocks.PLUGIN_FOLDER),"Commands"));
        this.messages = new HashMap<>();
    }
    public void addDefault(String name,String message) {
        messages.put(name,message);
    }
    public void addMessage(String name,String message) {
        getYaml().set(name,message);
        save();
    }
    public void setupKeys() {
        messages.keySet().forEach(message -> addMessage(message,messages.get(message)));
    }
    public String getMessage(String key) {
        return ChatColor.translateAlternateColorCodes('&',getYaml().getString(key));
    }
}
