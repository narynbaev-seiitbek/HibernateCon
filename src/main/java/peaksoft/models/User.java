package peaksoft.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;


@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToMany(cascade = {MERGE, PERSIST}, fetch = FetchType.EAGER)
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void removeById(Long id) {
        this.posts.removeIf(post -> post.getId().equals(id));
    }


}
