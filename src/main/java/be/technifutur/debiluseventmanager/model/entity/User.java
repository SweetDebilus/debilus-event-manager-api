package be.technifutur.debiluseventmanager.model.entity;

import be.technifutur.debiluseventmanager.util.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "/'user'/")
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "gender", nullable = false)
    private boolean gender;

    @Column(name = "character_id", unique = true)
    private String characterId;

    @Column(name = "character_name", nullable = false)
    private String characterName;

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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.rank.getId()==1 || this.rank.getId()==2){
            return List.of(new SimpleGrantedAuthority(Role.ADMIN.getRole()), new SimpleGrantedAuthority(Role.OFFICER.getRole()), new SimpleGrantedAuthority(Role.USER.getRole()));
        } else if (this.rank.getId()==3) {
            return List.of(new SimpleGrantedAuthority(Role.OFFICER.getRole()), new SimpleGrantedAuthority(Role.USER.getRole()));
        } else {
            return List.of(new SimpleGrantedAuthority(Role.USER.getRole()));
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

}
