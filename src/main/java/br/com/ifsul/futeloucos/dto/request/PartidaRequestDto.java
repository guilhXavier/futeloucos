package br.com.ifsul.futeloucos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartidaRequestDto {

    private String placarFinal;

    private String timeCasa;

    private Integer golsTimeCasa;

    private String timeVisitante;

    private Integer golsTimeVisitante;

    private Integer cartoesVermelhos;

    private Integer cartoesAmarelos;

    private Integer faltas;

    private Date dataPartida;
}
