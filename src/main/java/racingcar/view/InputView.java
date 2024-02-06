package racingcar.view;

import racingcar.dto.request.RaceCountRequest;
import racingcar.dto.request.RacingCarNamesRequest;

public interface InputView {
    RacingCarNamesRequest readRacingCarNames();

    RaceCountRequest readRaceCount();
}
