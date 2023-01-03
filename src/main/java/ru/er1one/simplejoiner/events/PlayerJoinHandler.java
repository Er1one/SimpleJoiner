package ru.er1one.simplejoiner.events;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import ru.er1one.simplejoiner.SimpleJoiner;
import ru.er1one.simplejoiner.models.JoinMessage;

public class PlayerJoinHandler implements Listener {

    private final NamespacedKey MESSAGE_KEY = new NamespacedKey(SimpleJoiner.getInstance(), "joinMessage");

    private final SimpleJoiner instance = SimpleJoiner.getInstance();

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        PersistentDataContainer data = player.getPersistentDataContainer();

        if (!data.has(MESSAGE_KEY, PersistentDataType.STRING)) {
            return;
        }

        String key = data.get(MESSAGE_KEY, PersistentDataType.STRING);

        JoinMessage message = instance.getJoinManager().getJoinMessage(key);

        if (message == null) {
            return;
        }

        event.setJoinMessage(null);

        message.send(player);
    }

}
