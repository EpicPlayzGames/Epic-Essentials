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

    }

}
