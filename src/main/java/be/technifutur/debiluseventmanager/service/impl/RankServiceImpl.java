package be.technifutur.debiluseventmanager.service.impl;

import be.technifutur.debiluseventmanager.model.dto.RankUserDTO;
import be.technifutur.debiluseventmanager.model.dto.UserRankDTO;
import be.technifutur.debiluseventmanager.model.entity.User;
import be.technifutur.debiluseventmanager.model.form.RankForm;
import be.technifutur.debiluseventmanager.repository.RankRepository;
import be.technifutur.debiluseventmanager.repository.UserRepository;
import be.technifutur.debiluseventmanager.service.RankService;
import org.springframework.stereotype.Service;
import be.technifutur.debiluseventmanager.model.entity.Rank;

import java.util.List;

@Service
public class RankServiceImpl implements RankService {

    private final RankRepository rankRepository;
    private final UserRepository userRepository;

    public RankServiceImpl(RankRepository rankRepository, UserRepository userRepository) {
        this.rankRepository = rankRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void createRank(RankForm rankForm) {
        Rank rank = rankForm.toEntity(rankForm);
        rankRepository.save(rank);
    }

    @Override
    public void updateRank(RankForm rankForm, long id) {
        Rank rankToUpdate = rankRepository.findById(id).orElseThrow(() -> new RuntimeException("Rank not found"));
        rankToUpdate.setName(rankForm.getName());
        rankRepository.save(rankToUpdate);
    }

    @Override
    public void deleteRank(Long id) {
        rankRepository.deleteById(id);
    }

    @Override
    public RankUserDTO getRankById(Long id) {
        return RankUserDTO.from(rankRepository.findById(id).orElseThrow(() -> new RuntimeException("Rank not found")));
    }

    @Override
    public List<RankUserDTO> getAllRanks() {
        return rankRepository.findAll().stream().map(RankUserDTO::from).toList();
    }
}
