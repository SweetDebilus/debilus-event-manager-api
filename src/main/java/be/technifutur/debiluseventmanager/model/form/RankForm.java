package be.technifutur.debiluseventmanager.model.form;

import be.technifutur.debiluseventmanager.model.entity.Rank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RankForm {

    private String name;

    public Rank toEntity(RankForm rankForm) {
        Rank rank = new Rank();
        rank.setName(rankForm.getName());
        return rank;
    }
}
