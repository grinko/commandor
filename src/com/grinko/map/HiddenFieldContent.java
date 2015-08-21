package com.grinko.map;

/**
 * Created by grinko on 19.8.15.
 */
public enum HiddenFieldContent {
    PISTOL (0, "You've found a Pistol.", "FIND"),
    WOLF (1, "You are attacked by wolves.", "ATTACK"),
    BEAR (2, "You are attacked by a bear.", "ATTACK"),
    PIT (3, "You fell into the pit.", "ACCIDENT"),
    OPTICAL_SIGHT (4, "You've found an optical sight.", "FIND"),
    PEOPLE (5, "You are attacked by a group of people.", "ATTACK"),
    ROUNDS_BOX (6,"You've found a box of bullets.", "FIND");

    private int id;
    private String message;
    private String eventType;

    private HiddenFieldContent(int id, String message, String eventType) {
        this.id = id;
        this.message = message;
        this.eventType = eventType;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getEventType() {
        return eventType;
    }
}
