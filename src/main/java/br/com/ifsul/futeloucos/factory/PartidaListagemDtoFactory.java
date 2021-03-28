package br.com.ifsul.futeloucos.factory;

import br.com.ifsul.futeloucos.dto.response.PartidaListagemDto;
import br.com.ifsul.futeloucos.model.Partida;

public class PartidaListagemDtoFactory {

    public static PartidaListagemDto criar(Partida partida) {
        return PartidaListagemDto.builder()
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
}
