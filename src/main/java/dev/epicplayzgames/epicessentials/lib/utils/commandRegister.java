package dev.epicplayzgames.epicessentials.lib.utils;

import dev.epicplayzgames.epicessentials.EpicEssentials;
import dev.epicplayzgames.epicessentials.lib.commands.*;

import java.util.Objects;

public class commandRegister {

    //Registers all commands within commands package
    public void RegisterCommands() {

        Objects.requireNonNull(EpicEssentials.getEpicEssentials().getServer().getPluginCommand("heal")).setExecutor(new healCommand());
        Objects.requireNonNull(EpicEssentials.getEpicEssentials().getServer().getPluginCommand("feed")).setExecutor(new feedCommand());
        Objects.requireNonNull(EpicEssentials.getEpicEssentials().getServer().getPluginCommand("spawn")).setExecutor(new spawnCommand());
        Objects.requireNonNull(EpicEssentials.getEpicEssentials().getServer().getPluginCommand("home")).setExecutor(new homeCommand());
        Objects.requireNonNull(EpicEssentials.getEpicEssentials().getServer().getPluginCommand("time")).setExecutor(new timeCommand());
        Objects.requireNonNull(EpicEssentials.getEpicEssentials().getServer().getPluginCommand("gm")).setExecutor(new gamemodeCommand());
        Objects.requireNonNull(EpicEssentials.getEpicEssentials().getServer().getPluginCommand("god")).setExecutor(new godCommand());
        Objects.requireNonNull(EpicEssentials.getEpicEssentials().getServer().getPluginCommand("cc")).setExecutor(new clearchatCommand());
        Objects.requireNonNull(EpicEssentials.getEpicEssentials().getServer().getPluginCommand("mc")).setExecutor(new mutechatCommand());

    }

}
