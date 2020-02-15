package me.Rokaz.InteractiveBlocks.core.config;

public abstract interface IConfig {
    public abstract String getConfig();
    public abstract void setupKeys();
    public abstract Section getSection();
    public abstract void save();
    public abstract void reload();
}
