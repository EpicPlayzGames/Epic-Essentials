package dev.epicplayzgames.epicessentials;

import dev.epicplayzgames.epicessentials.lib.utils.commandRegister;
import dev.epicplayzgames.epicessentials.lib.utils.eventRegister;
import org.bukkit.plugin.java.JavaPlugin;
public final class EpicEssentials extends JavaPlugin {
    @Override
    public void onEnable() {

        epicEssentials = this;
        System.out.println("Enabling Epic-Essentials by EpicPlayzGames.");
        getServer().getPluginManager().enablePlugin(epicEssentials);

        new commandRegister().RegisterCommands();
        new eventRegister().RegisterEvents();

    }

    @Override
    public void onDisable() {

        System.out.println("Disabling Epic-Essentials by EpicPlayzGames.");
        getServer().getPluginManager().disablePlugin(epicEssentials);

    }

    private static EpicEssentials epicEssentials;

    public static EpicEssentials getEpicEssentials() {
        return epicEssentials;
    }

}
