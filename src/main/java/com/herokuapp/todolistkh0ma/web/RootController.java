package com.herokuapp.todolistkh0ma.web;

import com.herokuapp.todolistkh0ma.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kh0ma on 11.02.17.
 */
@Controller
public class RootController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/")
    public String root() {
        return "redirect:mainpanel";
    }

    @GetMapping("/mainpanel")
    public String meals(ModelMap model) {
        model.put("projects", projectService.getAll(100000));
        return "mainpanel";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model,
                        @RequestParam(value = "error", required = false) boolean error,
                        @RequestParam(value = "message", required = false) String message) {
        model.put("error", error);
        model.put("message", message);
        return "login";
    }

}
