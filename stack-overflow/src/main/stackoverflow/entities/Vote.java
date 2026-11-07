package stackoverflow.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Vote {
    private int value;
    private stackoverflow.entities.User voter;
    private LocalDateTime dateCreated;
    private UUID id;

    public Vote(int value, stackoverflow.entities.User voter) {
        this.value = value;
        this.voter = voter;
        this.dateCreated = LocalDateTime.now();
        this.id = UUID.randomUUID();
    }

    public void setValue(int value) {
        this.value = value;
    }

    public stackoverflow.entities.User getVoter() {
        return voter;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public int getValue() {
        return value;
    }


}