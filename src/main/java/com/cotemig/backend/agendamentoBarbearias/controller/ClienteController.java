package com.cotemig.backend.agendamentoBarbearias.controller;

import com.cotemig.backend.agendamentoBarbearias.model.Cliente;
import com.cotemig.backend.agendamentoBarbearias.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public ModelAndView clientes(){
        ModelAndView mav = new ModelAndView("clientes");
        mav.addObject("clientes", clienteService.getAllClientes());
        return mav;
    }

    @RequestMapping(value = "insert_cliente", method = RequestMethod.GET)
    public ModelAndView insert(){
        return new ModelAndView("insert_cliente", "cliente", new Cliente());
    }

    @RequestMapping(value = "insert_cliente", method = RequestMethod.POST)
    public String submitInsert(@ModelAttribute("cliente") Cliente cliente, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "error";
        }
        clienteService.insertCliente(cliente);
        return "redirect:";
    }

    @RequestMapping(value = "/delete_cliente", method = RequestMethod.GET)
    public ModelAndView delete(Integer id){
        return new ModelAndView("delete_cliente", "cliente", clienteService.getClienteById(id).get());
    }

    @RequestMapping(value = "/delete_cliente", method = RequestMethod.POST)
    public String submitDelete(@ModelAttribute("cliente")Cliente cliente, BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            return "error";
        }
        clienteService.deleteClienteById(cliente.getId());
        return "redirect:";
    }

    @RequestMapping(value = "/update_cliente", method = RequestMethod.GET)
    public ModelAndView update(Integer id) {
        return new ModelAndView("update_cliente", "cliente", clienteService.getClienteById(id).get());
    }

    @RequestMapping(value = "/update_cliente", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("cliente") Cliente cliente, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        clienteService.updateCliente(cliente);
        return "redirect:";
    }

    @RequestMapping(value = "/read_cliente", method = RequestMethod.GET)
    public ModelAndView read() {
        ModelAndView mav = new ModelAndView("read_cliente");
        mav.addObject("clientes", clienteService.getAllClientes());
        return mav;
    }
}
