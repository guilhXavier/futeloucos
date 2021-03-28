package br.com.ifsul.futeloucos.factory;

import br.com.ifsul.futeloucos.dto.request.PartidaRequestDto;
import br.com.ifsul.futeloucos.model.Partida;

public class PartidaFactory {

    public static Partida criar(PartidaRequestDto partidaRequestDto) {
        return Partida.builder()
                .placarFinal(partidaRequestDto.getPlacarFinal())
                .timeCasa(partidaRequestDto.getTimeCasa())
                .golsTimeCasa(partidaRequestDto.getGolsTimeCasa())
                .timeVisitante(partidaRequestDto.getTimeVisitante())
                .golsTimeVisitante(partidaRequestDto.getGolsTimeVisitante())
                .cartoesVermelhos(partidaRequestDto.getCartoesVermelhos())
                .cartoesAmarelos(partidaRequestDto.getCartoesAmarelos())
                .faltas(partidaRequestDto.getFaltas())
                .dataPartida(partidaRequestDto.getDataPartida())
                .build();
    }
}
