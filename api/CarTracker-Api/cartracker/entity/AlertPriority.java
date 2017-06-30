package cartracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mannu.
 */

@Entity
public class AlertPriority {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AlertPriority{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
