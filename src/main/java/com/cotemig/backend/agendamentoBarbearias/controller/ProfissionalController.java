package com.cotemig.backend.agendamentoBarbearias.controller;

import com.cotemig.backend.agendamentoBarbearias.model.Profissional;
import com.cotemig.backend.agendamentoBarbearias.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @RequestMapping(value = "/profissional", method = RequestMethod.GET)
    public ModelAndView profissionais(){
        ModelAndView mav = new ModelAndView("profissional");
        mav.addObject("profissional", profissionalService.getAllProfissionais());
        return mav;
    }

    @RequestMapping(value = "/insert_profissional", method = RequestMethod.GET)
    public ModelAndView insert(){
        return new ModelAndView("insert_profissional", "profissional", new Profissional());
    }

    @RequestMapping(value = "/insert_profissional", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("profissional") Profissional profissional, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        profissionalService.insertProfissional(profissional);
        return "redirect:";
    }

    @RequestMapping(value = "/delete_profissional", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete_profissional", "profissional", profissionalService.getProfissionalById(id).get());
    }

    @RequestMapping(value = "/delete_profissional", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("profissional")Profissional profissional, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        profissionalService.deleteProfissionalById(profissional.getId());
        return "redirect:";
    }

    @RequestMapping(value = "/update_profissional", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update_profissional", "profissional", profissionalService.getProfissionalById(id).get());
    }

    @RequestMapping(value = "/update_profissional", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("profissional")Profissional profissional, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        profissionalService.updateProfissional(profissional);
        return "redirect:";
    }

    @RequestMapping(value = "/read_profissional", method = RequestMethod.GET)
    public ModelAndView read() {
        ModelAndView mav = new ModelAndView("read_profissional");
        mav.addObject("profissional", profissionalService.getAllProfissionais());
        return mav;
    }

}
