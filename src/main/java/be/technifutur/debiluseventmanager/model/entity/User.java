package be.technifutur.debiluseventmanager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "/'user'/")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "gender", nullable = false, length = 50)
    private String gender;

    @ManyToMany
    @JoinTable(
            name = "user_job",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id"))
    private List<Job> jobs;

    @ManyToOne
    @JoinColumn(name = "Rank_id", nullable = false)
    private Rank rank;

    @ManyToOne
    @JoinColumn(name = "Race_id", nullable = false)
    private Race race;

    @OneToMany(mappedBy = "user")
    private List<RegistrationHistory> registrationHistories;

    @OneToMany(mappedBy = "author")
    private List<ConflictReport> conflictReports;

    @OneToMany(mappedBy = "user")
    private List<Feedback> feedbacks;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", jobs=" + jobs +
                ", rank=" + rank +
                ", race=" + race +
                ", registrationHistories=" + registrationHistories +
                ", conflictReports=" + conflictReports +
                ", feedbacks=" + feedbacks +
                ", isActive=" + isActive +
                '}';
    }
}
