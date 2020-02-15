package me.Rokaz.InteractiveBlocks.core.config;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigManager {
    private List<Config> configs;
    private Plugin pl;
    public ConfigManager(Plugin pl) {
        this.pl = pl;
        configs = new ArrayList<>();
    }
    public void initialize() {
        setupDir();
    }
    public void setupDir() {
        File file =new File("plugins//" + InteractiveBlocks.PLUGIN_FOLDER);
        if (!file.exists()) {
            file.mkdir();
        }
    }
    public Config getYaml(String name) {
        return !configs.stream().filter(c -> c.getConfig().equals(name)).collect(Collectors.toList()).isEmpty()?configs.stream().filter(c -> c.getConfig().equals(name)).collect(Collectors.toList()).get(0):null;
    }
    public void registerConfig(Config c) {
        configs.add(c);
    }
    public void reloadAllConfigs() {
        configs.forEach(Config::reload);
    }
}
