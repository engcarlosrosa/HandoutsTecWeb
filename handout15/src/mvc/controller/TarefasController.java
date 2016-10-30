package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import mvc.model.Tarefa;

@Controller
public class TarefasController {

    @RequestMapping("/")
    public String execute() {
        System.out.println("Lógica do MVC");
        return "info";
    }
    
    @RequestMapping("homepage")
    public String execute1(){
    	return "homepage";
    }
    
    @RequestMapping("criaTarefa")
    public String form() {
        return "formTarefa";
    }
    @RequestMapping("adicionaTarefa")
    public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
    	if(result.hasErrors()) {
    	    return "formTarefa";
    	}

    	TarefaDAO dao = new TarefaDAO();
    	dao.adicionaDescricao(tarefa);
        return "adicionada";
    }
    
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
	    TarefaDAO dao = new TarefaDAO();
	    model.addAttribute("tarefas", dao.getLista());
	    return "lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
	    TarefaDAO dao = new TarefaDAO();
	    dao.remove(tarefa);
	    return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
	    TarefaDAO dao = new TarefaDAO();
	    model.addAttribute("tarefa", dao.buscaPorId(id));
	    return "mostra";
	}
	
	@RequestMapping("mostrafinalizaTarefa")
	public String mostrafinaliza(Long id, Model model) {
		TarefaDAO dao = new TarefaDAO();
		model.addAttribute("id", dao.buscaPorId(id));
		return "finaliza";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
	       TarefaDAO dao = new TarefaDAO();
	       dao.altera(tarefa);
	       return "redirect:listaTarefas";
	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id){
		TarefaDAO dao = new TarefaDAO();
		dao.finaliza(id);
		return "redirect:listaTarefas";
	}
}
