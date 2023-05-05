package be.technifutur.debiluseventmanager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "conflict_report")
@Getter
@Setter
public class ConflictReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "author_id")
    private User author;

    @ManyToMany
    @JoinTable(
            name = "conflict_report_user",
            joinColumns = @JoinColumn(name = "conflict_report_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> accused;

    private String message;
}
