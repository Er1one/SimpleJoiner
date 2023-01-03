package ru.er1one.simplejoiner.models;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import ru.er1one.simplejoiner.utils.StringUtils;

import javax.swing.text.PlainDocument;
import java.util.List;

public class JoinMessage {

    private String key;

    private String message = null;

    private List<String> listMessage = null;

    private Sound sound = null;

    private String title = null;

    private String subTitle = null;

    private String actionBarMessage = null;

    public JoinMessage(String key) {
        this.key = key;
    }

    public void send(Player player) {
        if (message != null) {
            StringUtils.broadcast(message);
        }
        if (listMessage != null) {
            StringUtils.broadcast(listMessage);
        }
        if (sound != null) {
            StringUtils.broadcast(sound);
        }
        if (title != null && subTitle != null) {
            StringUtils.broadcastTitle(title, subTitle);
        }
        if (title != null && subTitle == null) {
            StringUtils.broadcast(title);
        }
        if (actionBarMessage != null) {
            StringUtils.broadcastActionBar(actionBarMessage);
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setListMessage(List<String> listMessage) {
        this.listMessage = listMessage;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setActionBarMessage(String actionBarMessage) {
        this.actionBarMessage = actionBarMessage;
    }
}
