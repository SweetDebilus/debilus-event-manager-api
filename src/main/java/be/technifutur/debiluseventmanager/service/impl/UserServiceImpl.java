package be.technifutur.debiluseventmanager.service.impl;

import be.technifutur.debiluseventmanager.model.dto.UserDTO;
import be.technifutur.debiluseventmanager.model.entity.*;
import be.technifutur.debiluseventmanager.model.form.UserForm;
import be.technifutur.debiluseventmanager.repository.*;
import be.technifutur.debiluseventmanager.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RegistrationHistoryRepository registrationHistoryRepository;
    private final JobRepository jobRepository;
    private final RaceRepository raceRepository;
    private final RankRepository rankRepository;

    public UserServiceImpl(UserRepository userRepository, RegistrationHistoryRepository registrationHistoryRepository, JobRepository jobRepository, RaceRepository raceRepository, RankRepository rankRepository) {
        this.userRepository = userRepository;
        this.registrationHistoryRepository = registrationHistoryRepository;
        this.jobRepository = jobRepository;
        this.raceRepository = raceRepository;
        this.rankRepository = rankRepository;
    }

    @Override
    public void createUser(UserForm userForm) {
        User user = userForm.toEntity();
        RegistrationHistory registrationHistory = new RegistrationHistory();
        List<Job> jobs = new ArrayList<>();
        for (String job : userForm.getJobs()) {
            jobs.add(jobRepository.findByName(job));
        }
        Race race = raceRepository.findByName(userForm.getRace());
        Rank rank = rankRepository.findByName(userForm.getRank());
        user.setJobs(jobs);
        user.setRace(race);
        user.setRank(rank);
        user.setActive(true);
        registrationHistory.setUser(user);
        registrationHistory.setDateOfRegistration(LocalDate.now());
        userRepository.save(user);
        registrationHistoryRepository.save(registrationHistory);
    }

    @Override
    public void updateUser(UserForm userForm, Long id) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userToUpdate.setUsername(userForm.getUsername());
        userToUpdate.setPassword(userForm.getPassword());
        userToUpdate.setGender(userForm.isGender());
        List<Job> jobs = new ArrayList<>();
        for (String job : userForm.getJobs()) {
            jobs.add(jobRepository.findByName(job));
        }
        Race race = raceRepository.findByName(userForm.getRace());
        Rank rank = rankRepository.findByName(userForm.getRank());
        userToUpdate.setJobs(jobs);
        userToUpdate.setRace(race);
        userToUpdate.setRank(rank);
        userToUpdate.setActive(true);
        userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        User userToDelete = userRepository.findById(id).orElse(null);
        if (userToDelete != null) {
            userToDelete.setActive(false);
            userRepository.save(userToDelete);
        }
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id).map(UserDTO::from).orElse(null);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return UserDTO.from(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().filter(User::isActive).map(UserDTO::from).toList();
    }

    @Override
    public void reactivateUser(Long id) {
        User userToReactivate = userRepository.findById(id).orElse(null);
        if (userToReactivate != null) {
            RegistrationHistory registrationHistory = new RegistrationHistory();
            registrationHistory.setUser(userToReactivate);
            registrationHistory.setDateOfRegistration(LocalDate.now());
            registrationHistoryRepository.save(registrationHistory);
            userToReactivate.setActive(true);
            userRepository.save(userToReactivate);
        }
    }


}
