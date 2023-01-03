package ru.er1one.simplejoiner.managers;

import ru.er1one.simplejoiner.models.JoinMessage;

import java.util.HashMap;
import java.util.Map;

public class JoinManager {

    private final Map<String, JoinMessage> messages = new HashMap<>();

    public void addMessage(String key, JoinMessage message) {
        messages.put(key, message);
    }

    public JoinMessage getJoinMessage(String key) {
        return messages.get(key);
    }

}
