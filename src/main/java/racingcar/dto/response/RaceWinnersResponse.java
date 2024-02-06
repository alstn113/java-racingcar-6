package racingcar.dto.response;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;

public record RaceWinnersResponse(List<String> winners) {
    public static RaceWinnersResponse from(List<RacingCar> winners) {
        List<String> winnerNames = new ArrayList<>();
        winners.forEach(racingCar -> {
            String name = racingCar.getName();
            winnerNames.add(name);
        });
        return new RaceWinnersResponse(winnerNames);
    }
}
