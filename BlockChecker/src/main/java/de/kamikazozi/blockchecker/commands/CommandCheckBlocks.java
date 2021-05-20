package de.kamikazozi.blockchecker.commands;/**
 * @author Florian Dohms
 * <p>
 * Copyright (c) 2017 - 2020 by KamiKazozi to present. All rights served.
 */

import de.kamikazozi.blockchecker.utils.Data;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCheckBlocks implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Data.onlyPlayer);
            return true;
        }
        if (sender.hasPermission("blockchecker.check") || sender.hasPermission("blockchecker.*")) {
            Player player = (Player) sender;
            if (!(player.getInventory().getItemInHand() == null || player.getInventory().getItemInHand().getType() == Material.AIR)) {
                player.sendMessage(Data.prefix + "§7Das Item in deiner Hand ist: §b" + player.getInventory().getItemInHand().getType());
                player.sendMessage(Data.prefix + "§7Und hat die ID: §b" + player.getInventory().getItemInHand().getType().getId());
                player.sendMessage(Data.prefix + "§7Und kommt aus der Klasse: §b" + player.getInventory().getItemInHand().getType().getData());
            } else {
                player.sendMessage(Data.prefix + "§cNehme ein Gültiges Item in die Hand!");
            }
        } else {
            sender.sendMessage(Data.noPerm);
        }
        return true;
    }
}