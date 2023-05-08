package be.technifutur.debiluseventmanager.util;

import be.technifutur.debiluseventmanager.model.entity.*;
import be.technifutur.debiluseventmanager.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements InitializingBean {

    private final JobRepository jobRepository;
    private final RaceRepository raceRepository;
    private final RankRepository rankRepository;
    private final UserRepository userRepository;
    private final RegistrationHistoryRepository registrationHistoryRepository;

    public DataInit(JobRepository jobRepository, RaceRepository raceRepository, RankRepository rankRepository, UserRepository userRepository, RegistrationHistoryRepository registrationHistoryRepository) {
        this.jobRepository = jobRepository;
        this.raceRepository = raceRepository;
        this.rankRepository = rankRepository;
        this.userRepository = userRepository;
        this.registrationHistoryRepository = registrationHistoryRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Job job = new Job();
        job.setName("Warrior");
        jobRepository.save(job);
        job = new Job();
        job.setName("Dark Knight");
        jobRepository.save(job);
        job = new Job();
        job.setName("Paladin");
        jobRepository.save(job);
        job = new Job();
        job.setName("Gunbreaker");
        jobRepository.save(job);
        job = new Job();
        job.setName("White Mage");
        jobRepository.save(job);
        job = new Job();
        job.setName("Scholar");
        jobRepository.save(job);
        job = new Job();
        job.setName("Astrologian");
        jobRepository.save(job);
        job = new Job();
        job.setName("Sage");
        jobRepository.save(job);
        job = new Job();
        job.setName("Monk");
        jobRepository.save(job);
        job = new Job();
        job.setName("Dragoon");
        jobRepository.save(job);
        job = new Job();
        job.setName("Ninja");
        jobRepository.save(job);
        job = new Job();
        job.setName("Samurai");
        jobRepository.save(job);
        job = new Job();
        job.setName("Bard");
        jobRepository.save(job);
        job = new Job();
        job.setName("Machinist");
        jobRepository.save(job);
        job = new Job();
        job.setName("Reaper");
        jobRepository.save(job);
        job = new Job();
        job.setName("Dancer");
        jobRepository.save(job);
        job = new Job();
        job.setName("Black Mage");
        jobRepository.save(job);
        job = new Job();
        job.setName("Summoner");
        jobRepository.save(job);
        job = new Job();
        job.setName("Red Mage");
        jobRepository.save(job);
        job = new Job();
        job.setName("Blue Mage");
        jobRepository.save(job);

        Race race = new Race();
        race.setName("Hyur");
        raceRepository.save(race);
        race = new Race();
        race.setName("Elezen");
        raceRepository.save(race);
        race = new Race();
        race.setName("Lalafell");
        raceRepository.save(race);
        race = new Race();
        race.setName("Miqo'te");
        raceRepository.save(race);
        race = new Race();
        race.setName("Roegadyn");
        raceRepository.save(race);
        race = new Race();
        race.setName("Au Ra");
        raceRepository.save(race);
        race = new Race();
        race.setName("Hrothgar");
        raceRepository.save(race);
        race = new Race();
        race.setName("Viera");
        raceRepository.save(race);

        Rank rank = new Rank();
        rank.setName("Overlord");
        rankRepository.save(rank);
        rank = new Rank();
        rank.setName("ArchSuccubus");
        rankRepository.save(rank);
        rank = new Rank();
        rank.setName("Demon General");
        rankRepository.save(rank);
        rank = new Rank();
        rank.setName("Griefing Legend");
        rankRepository.save(rank);
        rank = new Rank();
        rank.setName("Demon/Succubus");
        rankRepository.save(rank);
        rank = new Rank();
        rank.setName("Fiend");
        rankRepository.save(rank);
        rank = new Rank();
        rank.setName("InHell");
        rankRepository.save(rank);
        rank = new Rank();
        rank.setName("Corrupted");
        rankRepository.save(rank);
        rank = new Rank();
        rank.setName("Alter Ego");
        rankRepository.save(rank);

        User user = new User();
        user.setUsername("SelenaSweetheart");
        user.setPassword("1234");
        user.setGender("Female");
        user.setJobs(jobRepository.findAll());
        user.setRace(raceRepository.findByName("Miqo'te"));
        user.setRank(rankRepository.findByName("Demon General"));
        user.setActive(true);
        RegistrationHistory registrationHistory = new RegistrationHistory();
        registrationHistory.setDateOfRegistration(LocalDate.now());
        registrationHistory.setUser(user);
        List<RegistrationHistory> registrationHistories = new ArrayList<>();
        registrationHistories.add(registrationHistory);
        user.setRegistrationHistories(registrationHistories);
        userRepository.save(user);
        registrationHistoryRepository.save(registrationHistory);

    }
}
