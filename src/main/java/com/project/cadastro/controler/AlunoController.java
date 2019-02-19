package com.project.cadastro.controler;


import com.project.cadastro.model.Aluno;
import com.project.cadastro.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlunoController {

    @Autowired
    AlunoService alunoService;


    @RequestMapping(value = "/aluno", method = RequestMethod.GET)
    public String alunoCadastroFormGet(){
        return "aluno/alunoform";
    }

    @RequestMapping(value = "/aluno", method = RequestMethod.POST)
    public String alunoCadastroPost(Aluno aluno){

        alunoService.addUser(aluno);

        return "redirect:/aluno/perfil";
    }

    @RequestMapping(value = "/aluno/perfil", method = RequestMethod.POST)
    public String alunoUp(Aluno aluno){

        System.out.println(aluno.getUsername());

        alunoService.updateAluno(aluno);

        return "redirect:/aluno/perfil";
    }

    @RequestMapping(value = "/aluno/perfil", method = RequestMethod.GET)
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("aluno/alunoUpdate");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(auth.getName());
        Aluno aluno = alunoService.findUserByLogin(auth.getName());
//        System.out.println(aluno.getUsername());
        mv.addObject("aluno", aluno);
        return mv;
    }

    @RequestMapping(value = "/deletarAluno", name = "deletarAluno" )
    public String deletarAluno(@RequestParam String login){

        alunoService.deleteUser(login);
        return "aluno/alunoform";
    }

}
