package racingcar.dto.request;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RaceParticipants;
import racingcar.domain.RacingCar;
import racingcar.domain.generator.NumberGenerator;
import racingcar.view.util.InputUtil;

public record RacingCarNamesRequest(String input) {
    public RaceParticipants toRaceParticipants(NumberGenerator numberGenerator) {
        String[] carNamesArray = InputUtil.splitByComma(input);
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : carNamesArray) {
            RacingCar racingCar = new RacingCar(name, numberGenerator);
            racingCars.add(racingCar);
        }
        return new RaceParticipants(racingCars);
    }
}
