package dev.epicplayzgames.epicessentials.utils;

import dev.epicplayzgames.epicessentials.EpicEssentials;
import dev.epicplayzgames.epicessentials.listeners.mutechatListener;
import dev.epicplayzgames.epicessentials.listeners.playerJoinLeaveEvent;
public class eventRegister {

    //Registers all events within listeners package
    public void RegisterEvents() {

        EpicEssentials.getEpicEssentials().getServer().getPluginManager().registerEvents(new playerJoinLeaveEvent(), EpicEssentials.getEpicEssentials());
        EpicEssentials.getEpicEssentials().getServer().getPluginManager().registerEvents(new mutechatListener(), EpicEssentials.getEpicEssentials());

    }

}
