package de.kamikazozi.blockchecker;/**
 * @author Florian Dohms
 * <p>
 * Copyright (c) 2017 - 2020 by KamiKazozi to present. All rights served.
 */

import de.kamikazozi.blockchecker.commands.CommandCheckBlocks;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockChecker extends JavaPlugin {

    public static BlockChecker Instance;

    @Override
    public void onEnable() {
        Instance = this;
        init();
    }

    public void init() {
        //Commands
        getCommand("check").setExecutor(new CommandCheckBlocks());
        //Listeners
        PluginManager pm = Bukkit.getPluginManager();
    }

    public static BlockChecker getInstance() {
        return Instance;
    }
}