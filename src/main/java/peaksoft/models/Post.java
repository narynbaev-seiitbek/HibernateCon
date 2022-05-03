package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 5000)
    private String description;
    private LocalDateTime dateTime;

    @ManyToMany(cascade = CascadeType.MERGE,mappedBy = "posts", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    public Post() {
        dateTime = LocalDateTime.now();
    }

    public Post(String description) {
        this.description = description;
        this.dateTime = LocalDateTime.now();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeById(Long id) {
        this.users.removeIf(user -> user.getId().equals(id));
    }
}
