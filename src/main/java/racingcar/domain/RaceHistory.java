package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RaceHistory {
    private final Map<RacingCar, List<Integer>> raceHistory = new LinkedHashMap<>();

    public RaceHistory(RaceParticipants raceParticipants) {
        initRaceHistory(raceParticipants);
    }

    private void initRaceHistory(RaceParticipants raceParticipants) {
        for (RacingCar racingCar : raceParticipants.getRacingCars()) {
            raceHistory.put(racingCar, new ArrayList<>());
        }
    }

    public void addHistory(RacingCar racingCar, int position) {
        raceHistory.get(racingCar).add(position);
    }

    public Map<RacingCar, List<Integer>> getRaceHistory() {
        return Collections.unmodifiableMap(raceHistory);
    }
}
