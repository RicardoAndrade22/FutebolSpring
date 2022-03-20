package com.FutebolSpring.FutebolSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.FutebolSpring.FutebolSpring.models.Jogador;


import com.FutebolSpring.FutebolSpring.repository.JogadorRepository;

@Controller
public class BuscaController {

	@Autowired
	private JogadorRepository jr;
	
	//GET
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView abrirIndex() {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		
		//POST
		@RequestMapping(value = "/", method = RequestMethod.POST)
		public ModelAndView buscarIndex(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome) {
			
			ModelAndView mv = new ModelAndView("index");
			String mensagem = "Resultados da busca por " + buscar;
			
			if(nome.equals("nomejogador")) {
				mv.addObject("jongadores", jr.findByNomes(buscar));
			
			}
			
			mv.addObject("mensagem", mensagem);
			
			return mv;
		}
	
}
