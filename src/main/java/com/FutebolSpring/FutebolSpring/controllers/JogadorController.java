package com.FutebolSpring.FutebolSpring.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.FutebolSpring.FutebolSpring.models.Jogador;
import com.FutebolSpring.FutebolSpring.repository.JogadorRepository;

@Controller
public class JogadorController {
	
	@Autowired
	private JogadorRepository jr;
	
	//CADASTRAR JOGADOR	
	@RequestMapping(value = "/cadastrojogador", method = RequestMethod.GET)
	public String form() {
		return "jogador/cadastro";
	}
	
	@RequestMapping(value = "/cadastrojogador", method = RequestMethod.POST)
	public String form(@Valid Jogador jogador, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos...");
			return "redirect:/cadastrojogador";
		}
		jr.save(jogador);
		attributes.addFlashAttribute("mensagem", "jogador cadastrado");
		return "redirect:/cadastrojogador";
	}
	
	//LISTAR JOGADOR
	@RequestMapping("/jogadores")
	public  ModelAndView listaJogadores() {
		ModelAndView mv = new ModelAndView("jogador/listaJogadores");
		//ITERABLE VAI RETORNAR ELEMENTOS DA CLASSE JOGADOR PARA SEREM USADOS EM LOOP
		Iterable<Jogador> jogadores = jr.findAll();
		mv.addObject("jogadores", jogadores);
		return mv;
	}
	
	//Deleta jogador
	@RequestMapping("/deletaJogador")
	public String deletaJogador(long id) {
		Jogador jogador = jr.findById(id);
		jr.delete(jogador);
		return "redirect:/jogadores";
	}
	
	// Métodos que atualizam jogador
	// formulário edição de jogador
	@RequestMapping(value = "/atualizaJogador", method = RequestMethod.GET)
	public ModelAndView editarJogador(long id) {
		Jogador jogador = jr.findById(id);
		ModelAndView mv = new ModelAndView("jogador/update_jogador");
		mv.addObject("jogador", jogador);
		return mv;
	}
	
	//Update-vaga
	
	@RequestMapping(value = "/atualizaJogador", method = RequestMethod.POST)
	public String updateJogador(@Valid Jogador jogador, BindingResult result, RedirectAttributes attributes) {
		jr.save(jogador);
		attributes.addFlashAttribute("success", "Jogador alterada com sucesso!");

	long idLong = jogador.getId();
	String id = "" + idLong;
	return "redirect:/" + id;
	}
	
	
}
