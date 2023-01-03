package ru.er1one.simplejoiner.commands;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import ru.er1one.simplejoiner.SimpleJoiner;

public class SetMessageCommand implements CommandExecutor {

    private final NamespacedKey MESSAGE_KEY = new NamespacedKey(SimpleJoiner.getInstance(), "joinMessage");


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        player.getPersistentDataContainer().set(MESSAGE_KEY, PersistentDataType.STRING, "first");

        return true;
    }
}
