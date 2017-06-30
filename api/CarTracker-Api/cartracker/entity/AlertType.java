package cartracker.entity;

import javax.persistence.*;

/**
 * Created by mannu.
 */

@Entity
public class AlertType {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String description;

    @OneToOne
    private AlertPriority alertPriority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AlertPriority getPriority() {
        return alertPriority;
    }

    public void setPriority(AlertPriority alertPriority) {
        this.alertPriority = alertPriority;
    }

    @Override
    public String toString() {
        return "AlertType{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + alertPriority +
                '}';
    }
}
