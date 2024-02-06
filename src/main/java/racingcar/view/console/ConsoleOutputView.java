package racingcar.view.console;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.dto.response.RaceHistoryResponse;
import racingcar.dto.response.RaceWinnersResponse;
import racingcar.view.OutputView;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printRaceHistory(RaceHistoryResponse raceHistoryResponse) {
        Map<String, List<Integer>> raceHistory = raceHistoryResponse.raceHistory();
        int raceCount = raceHistoryResponse.raceCount();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < raceCount; i++) {
            for (Entry<String, List<Integer>> entry : raceHistory.entrySet()) {
                String racingCarName = entry.getKey();
                List<Integer> positions = entry.getValue();
                System.out.println(racingCarName + " : " + "-".repeat(positions.get(i)));
            }

            if (i != raceCount - 1) {
                System.out.println();
            }
        }
    }

    @Override
    public void printRaceWinners(RaceWinnersResponse raceWinnersResponse) {
        String winners = String.join(",", raceWinnersResponse.winners());

        System.out.println();
        System.out.printf("최종 우승자 : %s", winners);
    }
}
