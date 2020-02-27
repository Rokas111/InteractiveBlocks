package me.Rokaz.InteractiveBlocks.core.blocks.config;

import me.Rokaz.InteractiveBlocks.core.InteractiveBlocks;
import me.Rokaz.InteractiveBlocks.core.config.Config;
import me.Rokaz.InteractiveBlocks.core.config.Section;

public class BlocksConfig extends Config {
    public BlocksConfig() {
        super("config",new Section(InteractiveBlocks.PLUGIN_FOLDER));
        if (!setup()) {
            setupKeys();
        }
    }
    public void setupKeys() {
        getYaml().set("activate_cooldowns",false);
        getYaml().set("cooldown",20);
        save();
    }
    public int getCooldown() {
        return getYaml().getInt("cooldown");
    }
    public boolean getActivateCooldowns() {
        return getYaml().getBoolean("activate_cooldowns");
    }
}
