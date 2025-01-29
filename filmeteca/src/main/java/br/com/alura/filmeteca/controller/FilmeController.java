package br.com.alura.filmeteca.controller;

import br.com.alura.filmeteca.domain.Filme;
import br.com.alura.filmeteca.dto.DadosCadastroFilme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(){
        return "formulario";
    }

    @GetMapping
    public String carraPaginaListagem(Model model){
        model.addAttribute("lista",filmes);
        return "listagem";
    }

    @PostMapping
    public String cadastraFilme(DadosCadastroFilme dados){
        Filme filme = new Filme(dados);
        filmes.add(filme);

        return "redirect:/filmes";
    }

}
