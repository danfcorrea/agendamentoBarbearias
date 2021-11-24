package com.cotemig.backend.agendamentoBarbearias.controller;

import com.cotemig.backend.agendamentoBarbearias.model.Servico;
import com.cotemig.backend.agendamentoBarbearias.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @RequestMapping(value = "/servicos", method = RequestMethod.GET)
    public ModelAndView servicos(){
        ModelAndView mav = new ModelAndView("servicos");
        mav.addObject("servicos", servicoService.getAllServicos());
        return mav;
    }

    @RequestMapping(value = "/insert_servico", method = RequestMethod.GET)
    public ModelAndView insert() {
        return new ModelAndView("insert_servico", "servico", new Servico());
    }

    @RequestMapping(value = "/insert_servico", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("servico")Servico servico, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        servicoService.insertServico(servico);
        return "redirect:";
    }

    @RequestMapping(value = "/delete_servico", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) {
        return new ModelAndView("delete_servico", "servico", servicoService.getServicoById(id).get());
    }

    @RequestMapping(value = "/delete_servico", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("servico")Servico servico, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        servicoService.deleteServicoById(servico.getId());
        return "redirect:";
    }

    @RequestMapping(value = "/update_servico", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update_servico", "servico", servicoService.getServicoById(id).get());
    }

    @RequestMapping(value = "/update_servico", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("servico")Servico servico, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        servicoService.updateServico(servico);
        return "redirect:";
    }

    @RequestMapping(value = "/read_servico", method = RequestMethod.GET)
    public ModelAndView read() {
        ModelAndView mav = new ModelAndView("read_servicos");
        mav.addObject("servicos", servicoService.getAllServicos());
        return mav;
    }
}
