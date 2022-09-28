package dev.epicplayzgames.epicessentials.utils;

import dev.epicplayzgames.epicessentials.EpicEssentials;
import dev.epicplayzgames.epicessentials.commands.*;

public class commandRegister {

    //Registers all commands within commands package
    public void RegisterCommands() {

        EpicEssentials.getEpicEssentials().getServer().getPluginCommand("heal").setExecutor(new healCommand());
        EpicEssentials.getEpicEssentials().getServer().getPluginCommand("feed").setExecutor(new feedCommand());
        EpicEssentials.getEpicEssentials().getServer().getPluginCommand("spawn").setExecutor(new spawnCommand());
        EpicEssentials.getEpicEssentials().getServer().getPluginCommand("home").setExecutor(new homeCommand());
        EpicEssentials.getEpicEssentials().getServer().getPluginCommand("time").setExecutor(new timeCommand());
        EpicEssentials.getEpicEssentials().getServer().getPluginCommand("gm").setExecutor(new gamemodeCommand());
        EpicEssentials.getEpicEssentials().getServer().getPluginCommand("god").setExecutor(new godCommand());
        EpicEssentials.getEpicEssentials().getServer().getPluginCommand("cc").setExecutor(new clearchatCommand());
        EpicEssentials.getEpicEssentials().getServer().getPluginCommand("mc").setExecutor(new mutechatCommand());

    }

}
