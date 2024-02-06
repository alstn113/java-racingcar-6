package racingcar.dto.response;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.RaceHistory;

public record RaceHistoryResponse(Map<String, List<Integer>> raceHistory, int raceCount) {
    public static RaceHistoryResponse from(RaceHistory raceHistory) {
        Map<String, List<Integer>> raceHistoryResponse = new LinkedHashMap<>();
        raceHistory.getRaceHistory().forEach((racingCar, position) -> {
            String racingCarName = racingCar.getName();
            raceHistoryResponse.put(racingCarName, position);
        });

        int raceCount = raceHistoryResponse.values().stream()
                .findFirst()
                .map(List::size)
                .orElse(0);

        return new RaceHistoryResponse(raceHistoryResponse, raceCount);
    }
}
