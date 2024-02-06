package racingcar.view.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.request.RaceCountRequest;
import racingcar.dto.request.RacingCarNamesRequest;
import racingcar.view.InputView;

public class ConsoleInputView implements InputView {
    @Override
    public RacingCarNamesRequest readRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return new RacingCarNamesRequest(input);
    }

    @Override
    public RaceCountRequest readRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return new RaceCountRequest(input);
    }
}
