package br.com.ifsul.futeloucos.controller;

import br.com.ifsul.futeloucos.dto.request.PartidaRequestDto;
import br.com.ifsul.futeloucos.dto.response.PartidaListagemDto;
import br.com.ifsul.futeloucos.dto.response.PartidaResponseDto;
import br.com.ifsul.futeloucos.dto.response.PartidaResumidaResponseDto;
import br.com.ifsul.futeloucos.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/partida")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaService partidaService;

    @PostMapping
    public ResponseEntity<PartidaResponseDto> cadastrar(@RequestBody PartidaRequestDto partidaRequestDto) {
        return ResponseEntity.ok(partidaService.cadastrarPartida(partidaRequestDto));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PartidaResponseDto> atualizar(@PathVariable("id") Integer id, @RequestBody PartidaRequestDto partidaRequestDto) {
        return ResponseEntity.ok(partidaService.atualizarPartida(id, partidaRequestDto));
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(partidaService.excluirPartida(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaResponseDto> buscarPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(partidaService.buscarPartidaPorId(id));
    }

    @GetMapping("/todas")
    public ResponseEntity<List<PartidaListagemDto>> buscarTodas() {
        return ResponseEntity.ok(partidaService.buscarTodasPartidas());
    }

    @GetMapping("/paginada")
    public ResponseEntity<Page<PartidaResponseDto>> buscarTodasPaginada(@RequestParam Integer pagina) {
        return ResponseEntity.ok(partidaService.buscarPartidasPaginadas(pagina));
    }

    @GetMapping("/time-da-casa")
    public ResponseEntity<List<PartidaResponseDto>> buscarPorTimeDaCasa(@RequestParam String timeDaCasa) {
        return ResponseEntity.ok(partidaService.buscarPorTimeCasa(timeDaCasa));
    }

    @GetMapping("/placar-final")
    public ResponseEntity<List<PartidaResumidaResponseDto>> buscarResumidaPorPlacarFinal(@RequestParam String placarFinal) {
        return ResponseEntity.ok(partidaService.buscaResumidaPorPlacarFinal(placarFinal));
    }

    @GetMapping("/datas")
    public ResponseEntity<List<PartidaResponseDto>> buscarPorIntervaloDatas(@RequestParam Date dataInicial, @RequestParam Date dataFinal) {
        return ResponseEntity.ok(partidaService.buscarPorIntervaloData(dataInicial, dataFinal));
    }
}
