package br.com.ifsul.futeloucos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartidaResumidaResponseDto {

    private String placarFinal;

    private String timeCasa;

    private String timeVisitante;
}
