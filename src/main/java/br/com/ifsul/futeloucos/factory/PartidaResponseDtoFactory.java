package br.com.ifsul.futeloucos.factory;

import br.com.ifsul.futeloucos.dto.response.PartidaResponseDto;
import br.com.ifsul.futeloucos.dto.response.PartidaResumidaResponseDto;
import br.com.ifsul.futeloucos.model.Partida;

public class PartidaResponseDtoFactory {

    public static PartidaResponseDto criar(Partida partida) {
        return PartidaResponseDto.builder()
                .id(partida.getId())
                .placarFinal(partida.getPlacarFinal())
                .timeCasa(partida.getTimeCasa())
                .golsTimeCasa(partida.getGolsTimeCasa())
                .timeVisitante(partida.getTimeVisitante())
                .golsTimeVisitante(partida.getGolsTimeVisitante())
                .cartoesVermelhos(partida.getCartoesVermelhos())
                .cartoesAmarelos(partida.getCartoesAmarelos())
                .faltas(partida.getFaltas())
                .dataPartida(partida.getDataPartida())
                .build();
    }

    public static PartidaResumidaResponseDto criarPartidaResumida(Partida partida) {
        return PartidaResumidaResponseDto.builder()
                .placarFinal(partida.getPlacarFinal())
                .timeCasa(partida.getTimeCasa())
                .timeVisitante(partida.getTimeVisitante())
                .build();
    }
}
