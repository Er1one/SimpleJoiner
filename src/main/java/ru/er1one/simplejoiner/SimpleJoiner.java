package ru.er1one.simplejoiner;

import org.bukkit.Sound;
import org.bukkit.plugin.java.JavaPlugin;
import ru.er1one.simplejoiner.commands.SetMessageCommand;
import ru.er1one.simplejoiner.events.PlayerJoinHandler;
import ru.er1one.simplejoiner.managers.JoinManager;
import ru.er1one.simplejoiner.models.JoinMessage;

import java.util.List;

public final class SimpleJoiner extends JavaPlugin {

    private JoinManager joinManager;

    private static SimpleJoiner instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        joinManager = new JoinManager();
        loadJoinMessage();
        getCommand("setmessage").setExecutor(new SetMessageCommand());
        getServer().getPluginManager().registerEvents(new PlayerJoinHandler(), this);
    }

    private void loadJoinMessage() {
        for (String key : getConfig().getConfigurationSection("messages").getKeys(false)) {
            JoinMessage message = new JoinMessage(key);
            if (getConfig().get("messages." + key + ".message") instanceof String) {
                message.setMessage(getConfig().getString("messages." + key + ".message"));
            }
            if (getConfig().get("messages." + key + ".message") instanceof List) {
                message.setListMessage(getConfig().getStringList("messages." + key + ".message"));
            }
            if (getConfig().contains("messages." + key + ".sound")) {
                message.setSound(Sound.valueOf(getConfig().getString("messages." + key + ".sound")));
            }
            if (getConfig().contains("messages." + key + ".title")) {
                String[] title = getConfig().getString("messages." + key + ".title").split(";");
                if (title.length == 1) {
                    message.setTitle(title[0]);
                } else {
                    message.setTitle(title[0]);
                    message.setSubTitle(title[1]);
                }
            }
            if (getConfig().contains("messages." + key + ".action-bar")) {
                message.setActionBarMessage(getConfig().getString("messages." + key + ".action-bar"));
            }
            joinManager.addMessage(key, message);
        }
    }

    public static SimpleJoiner getInstance() {
        return instance;
    }

    public JoinManager getJoinManager() {
        return joinManager;
    }
}
