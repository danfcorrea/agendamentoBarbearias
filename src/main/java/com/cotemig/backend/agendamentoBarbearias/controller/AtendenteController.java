package com.cotemig.backend.agendamentoBarbearias.controller;

import com.cotemig.backend.agendamentoBarbearias.model.Atendente;
import com.cotemig.backend.agendamentoBarbearias.service.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AtendenteController {

    @Autowired
    private AtendenteService atendenteService;

    @RequestMapping(value = "/atendente", method = RequestMethod.GET)
    public ModelAndView atendentes(){
        ModelAndView mav = new ModelAndView("atendentes");
        mav.addObject("atendentes", atendenteService.getAllAtendentes());
        return mav;
    }

    @RequestMapping(value = "/insert_atendente", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert_atendentes", "atendente", new Atendente());
    }

    @RequestMapping(value = "/insert_atendente", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("atendente")Atendente atendente, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        atendenteService.insertAtendente(atendente);
        return "redirect:";
    }

    @RequestMapping(value = "/delete_atendente", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete_atendente", "atendente", atendenteService.getAtendenteById(id).get());
    }

    @RequestMapping(value = "/delete_atendente", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("atendente")Atendente atendente, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        atendenteService.deleteAtendenteById(atendente.getId());
        return "redirect:";
    }

    @RequestMapping(value = "/update_atendente", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update_atendente", "atendente", atendenteService.getAtendenteById(id).get());
    }

    @RequestMapping(value = "/update_atendente", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("atendente")Atendente atendente, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        atendenteService.updateAtendente(atendente);
        return "redirect:";
    }

    @RequestMapping(value = "/read_atendente", method = RequestMethod.GET)
    public ModelAndView read() {
        ModelAndView mav = new ModelAndView("read_atendentes");
        mav.addObject("atendentes", atendenteService.getAllAtendentes());
        return mav;
    }
}
