package lotto.domain.dto;

import lotto.domain.model.Lotto;

import java.util.List;

public class RandomLottoDto {
    public static String lottoToString(List<Lotto> randomLottos){
        StringBuilder lottoBuilder = new StringBuilder();
        randomLottos.forEach(lotto ->
                lottoBuilder.append(lotto.getLottoNumbers()).append("\n")
        );

        return lottoBuilder.toString();
    }
}
