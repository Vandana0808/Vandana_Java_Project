package com.example.todo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.todo.entity.ToDo;
import com.example.todo.service.LoginService;
import com.example.todo.service.TodoService;

@Controller
public class ToDoController {
	
	@Autowired
	private TodoService service;

//	@InitBinder
//    public void initBinder(WebDataBinder binder) {
//        // Date - dd-MM-yyyy
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }
	
	@GetMapping("/list-todos")
	public ModelAndView todos() {
//		String email = service.getLoggedInUserName(model);
//		User todo = lgservice.getUserByEmail(email);
		ModelAndView mv = new ModelAndView("todos");
		List<ToDo> todos = service.getAllWork();
		mv.addObject("todos", todos);
		return mv;
	}
	
	@GetMapping("/addWork")
	public String addWork() {
		return "addNew";
	}
	
	@PostMapping("/saveWork")
	public String saveWork(@ModelAttribute("td") ToDo td) {
		System.out.println(td.toString());
		service.add(td);
		return "redirect:/list-todos";
	}
	
	@GetMapping("/edit/{workId}")
	public ModelAndView editWork(@PathVariable("workId") int workId) {
		ModelAndView mv = new ModelAndView("edit");
		ToDo td = service.getworkById(workId);
		System.out.println("Td from edit block"+td.toString());
		mv.addObject("td", td);
		return mv;
	}

	@GetMapping("/delete/{workId}")
	public String deleteWork(@PathVariable("workId") int workId){
		 service.deleteWorkById(workId);
		 return "redirect:/list-todos";
	}
}
