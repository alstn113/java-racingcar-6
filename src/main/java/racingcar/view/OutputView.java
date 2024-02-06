package racingcar.view;

import racingcar.dto.response.RaceHistoryResponse;
import racingcar.dto.response.RaceWinnersResponse;

public interface OutputView {
    void printRaceHistory(RaceHistoryResponse raceHistoryResponse);

    void printRaceWinners(RaceWinnersResponse raceWinnersResponse);
}
