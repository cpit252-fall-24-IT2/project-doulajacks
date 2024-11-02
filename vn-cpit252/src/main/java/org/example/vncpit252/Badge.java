package org.example.vncpit252;

public class Badge {
    private final String name;
    private final String description;
    private final String badgeId;
    private boolean isEarned;

    // Constructor with parameters
    public Badge(String name, String description, String badgeId) {
        this.name = name;
        this.description = description;
        this.badgeId = badgeId;
        this.isEarned = false; // Initially, badge is not earned
    }

    // No-argument constructor with default values
    public Badge() {
        this.name = "Default Badge";
        this.description = "Default Description";
        this.badgeId = "DefaultBadgeID";
        this.isEarned = false;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBadgeId() {
        return badgeId;
    }

    // Method to check if the badge is earned
    public boolean isEarned() {
        return isEarned;
    }

    // Method to earn the badge
    public void earnBadge() {
        if (!isEarned) {
            isEarned = true;
            System.out.println("Congratulations! You've earned the badge: " + name);
        } else {
            System.out.println("Badge " + name + " has already been earned.");
        }
    }

    @Override
    public String toString() {
        return "Badge{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", badgeId='" + badgeId + '\'' +
                ", isEarned=" + isEarned +
                '}';
    }
}