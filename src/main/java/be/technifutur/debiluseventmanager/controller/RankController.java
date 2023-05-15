package be.technifutur.debiluseventmanager.controller;

import be.technifutur.debiluseventmanager.model.dto.RankDTO;
import be.technifutur.debiluseventmanager.model.dto.RankUserDTO;
import be.technifutur.debiluseventmanager.model.form.RankForm;
import be.technifutur.debiluseventmanager.service.RankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranks")
public class RankController {

    private final RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @PostMapping("/create")
    public void createRank(@RequestBody RankForm rankForm) {
        rankService.createRank(rankForm);
    }

    @PatchMapping("/{id}/update")
    public void updateRank(@RequestBody RankForm rankForm, @PathVariable Long id) {
        rankService.updateRank(rankForm, id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteRank(@PathVariable Long id) {
        rankService.deleteRank(id);
    }

    @GetMapping("/{id}")
    public RankUserDTO getRankById(@PathVariable Long id) {
        return rankService.getRankById(id);
    }

    @GetMapping("/all")
    public List<RankUserDTO> getAllRanks() {
        return rankService.getAllRanks();
    }
}
