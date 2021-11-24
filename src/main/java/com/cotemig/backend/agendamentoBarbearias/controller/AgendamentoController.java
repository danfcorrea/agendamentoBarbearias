package com.cotemig.backend.agendamentoBarbearias.controller;

import com.cotemig.backend.agendamentoBarbearias.model.Agendamento;
import com.cotemig.backend.agendamentoBarbearias.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("agendamento", agendamentoService.getAllAgendamentos());
        return mav;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert", "agendamento", new Agendamento());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("agendamento")Agendamento agendamento, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        agendamentoService.insertAgendamento(agendamento);
        return "redirect:";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete", "agendamento", agendamentoService.getAgendamentoById(id).get());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("agendamento")Agendamento agendamento, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        agendamentoService.deleteAgendamentoById(agendamento.getId());
        return "redirect:";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update", "agendamento", agendamentoService.getAgendamentoById(id).get());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("agendamento")Agendamento agendamento, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        agendamentoService.updateAgendamento(agendamento);
        return "redirect:";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ModelAndView read() {
        ModelAndView mav = new ModelAndView("read");
        mav.addObject("agendamentos", agendamentoService.getAllAgendamentos());
        return mav;
    }
}
