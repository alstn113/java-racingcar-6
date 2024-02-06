package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.RaceParticipants;
import racingcar.domain.generator.NumberGenerator;
import racingcar.dto.request.RaceCountRequest;
import racingcar.dto.request.RacingCarNamesRequest;
import racingcar.dto.response.RaceHistoryResponse;
import racingcar.dto.response.RaceWinnersResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController implements Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingController(InputView inputView, OutputView outputView,
                            NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }


    @Override
    public void run() {
        RaceParticipants raceParticipants = readRacingCarNames();
        int raceCount = readRaceCount();
        Race race = new Race(raceParticipants, raceCount);
        outputView.printRaceHistory(RaceHistoryResponse.from(race.getRaceHistory()));
        outputView.printRaceWinners(RaceWinnersResponse.from(race.getRaceWinners()));
    }

    private RaceParticipants readRacingCarNames() {
        RacingCarNamesRequest dto = inputView.readRacingCarNames();
        return dto.toRaceParticipants(numberGenerator);
    }

    private int readRaceCount() {
        RaceCountRequest dto = inputView.readRaceCount();
        return dto.toInt();
    }
}
