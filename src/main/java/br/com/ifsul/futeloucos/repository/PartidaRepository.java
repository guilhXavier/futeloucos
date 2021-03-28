package br.com.ifsul.futeloucos.repository;

import br.com.ifsul.futeloucos.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Integer> {

    List<Partida> findAllByTimeCasa(String timeCasa);

    List<Partida> findAllByPlacarFinal(String placarFinal);

    List<Partida> findAllByDataPartidaBetween(Date dataInicial, Date dataFinal);

}
