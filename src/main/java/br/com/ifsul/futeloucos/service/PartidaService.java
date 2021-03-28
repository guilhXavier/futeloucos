package br.com.ifsul.futeloucos.service;

import br.com.ifsul.futeloucos.dto.request.PartidaRequestDto;
import br.com.ifsul.futeloucos.dto.response.PartidaListagemDto;
import br.com.ifsul.futeloucos.dto.response.PartidaResponseDto;
import br.com.ifsul.futeloucos.dto.response.PartidaResumidaResponseDto;
import br.com.ifsul.futeloucos.factory.PartidaFactory;
import br.com.ifsul.futeloucos.factory.PartidaListagemDtoFactory;
import br.com.ifsul.futeloucos.factory.PartidaResponseDtoFactory;
import br.com.ifsul.futeloucos.model.Partida;
import br.com.ifsul.futeloucos.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartidaService {

    private final PartidaRepository partidaRepository;

    public PartidaResponseDto cadastrarPartida(PartidaRequestDto partida) {
        return PartidaResponseDtoFactory.criar(partidaRepository.save(PartidaFactory.criar(partida)));
    }

    public PartidaResponseDto atualizarPartida(Integer id, PartidaRequestDto partida) {
        Partida partidaModel = PartidaFactory.criar(partida);
        partidaModel.setId(id);

        return PartidaResponseDtoFactory.criar(partidaRepository.save(partidaModel));
    }

    public String excluirPartida(Integer id) {
        partidaRepository.deleteById(id);
        return "Excluido!";
    }

    public PartidaResponseDto buscarPartidaPorId(Integer id) {
        return PartidaResponseDtoFactory.criar(partidaRepository.findById(id).orElse(new Partida()));
    }

    public List<PartidaListagemDto> buscarTodasPartidas() {
        return partidaRepository.findAll()
                .stream()
                .map(PartidaListagemDtoFactory::criar)
                .collect(Collectors.toList());
    }

    public Page<PartidaResponseDto> buscarPartidasPaginadas(Integer pagina) {
        Pageable page = PageRequest.of(pagina, 5);
        return partidaRepository.findAll(page).map(PartidaResponseDtoFactory::criar);
    }

    public List<PartidaResponseDto> buscarPorTimeCasa(String timeCasa) {
        return partidaRepository.findAllByTimeCasa(timeCasa)
                .stream()
                .map(PartidaResponseDtoFactory::criar)
                .collect(Collectors.toList());
    }

    public List<PartidaResumidaResponseDto> buscaResumidaPorPlacarFinal(String placarFinal) {
        return partidaRepository.findAllByPlacarFinal(placarFinal)
                .stream()
                .map(PartidaResponseDtoFactory::criarPartidaResumida)
                .collect(Collectors.toList());
    }

    public List<PartidaResponseDto> buscarPorIntervaloData(Date dataInicial, Date dataFinal) {
        return partidaRepository.findAllByDataPartidaBetween(dataInicial, dataFinal)
                .stream()
                .map(PartidaResponseDtoFactory::criar)
                .collect(Collectors.toList());
    }

}
