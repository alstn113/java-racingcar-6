package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final RaceParticipants raceParticipants;
    private final RaceHistory raceHistory;

    public Race(RaceParticipants raceParticipants, int raceCount) {
        this.raceParticipants = raceParticipants;
        this.raceHistory = new RaceHistory(raceParticipants);
        startRace(raceParticipants, raceCount);
    }

    private void startRace(RaceParticipants raceParticipants, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            for (RacingCar racingCar : raceParticipants.getRacingCars()) {
                racingCar.moveOrStop();
                raceHistory.addHistory(racingCar, racingCar.getPosition());
            }
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (RacingCar racingCar : raceParticipants.getRacingCars()) {
            maxPosition = Math.max(maxPosition, racingCar.getPosition());
        }
        return maxPosition;
    }

    public RaceHistory getRaceHistory() {
        return raceHistory;
    }

    public List<RacingCar> getRaceWinners() {
        int maxPosition = getMaxPosition();
        List<RacingCar> raceWinners = new ArrayList<>();
        for (RacingCar racingCar : raceParticipants.getRacingCars()) {
            if (racingCar.getPosition() == maxPosition) {
                raceWinners.add(racingCar);
            }
        }
        return raceWinners;
    }
}
