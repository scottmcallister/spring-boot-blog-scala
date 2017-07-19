package com.example.microblogscala.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

/**
  * Created by scottmcallister on 2017-07-18.
  */
@Controller
class HomeController {
  @RequestMapping(Array("/"))
  def home(model: Model) = {
    model.addAttribute("message", "Hello World!")
    "index"
  }
}
