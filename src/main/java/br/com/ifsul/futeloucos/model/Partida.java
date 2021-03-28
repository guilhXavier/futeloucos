package br.com.ifsul.futeloucos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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
