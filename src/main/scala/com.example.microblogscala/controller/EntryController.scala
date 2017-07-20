package com.example.microblogscala.controller

import com.example.microblogscala.domain.Entry
import com.example.microblogscala.repository.EntryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestMethod, RequestParam}

@Controller
class EntryController @Autowired() (entryRepository: EntryRepository) {
  @RequestMapping(Array("/"))
  def home(model: Model) = {
    val allEntries = entryRepository.findAll()
    model.addAttribute("entries", allEntries)
    "home"
  }

  @RequestMapping(value = Array("/entry"), method = Array(RequestMethod.GET))
  def newEntry(model: Model): String = {
    model.addAttribute("pageTitle", "New Entry")
    model.addAttribute("givenAction", "/entry")
    model.addAttribute("givenTitle", "")
    model.addAttribute("givenContent", "")
    "entry"
  }

  @RequestMapping(value = Array("/entry"), method = Array(RequestMethod.POST))
  def addEntry(@RequestParam title: String, @RequestParam content: String): String = {
    val newEntry = new Entry(title, content)
    entryRepository.save(newEntry)
    "redirect:/"
  }

  @RequestMapping(value = Array("/entry/{id}"), method = Array(RequestMethod.GET))
  def editEntry(@PathVariable(value = "id") entryId: Long, model: Model): String = {
    val entry = entryRepository.findOne(entryId)
    model.addAttribute("pageTitle", "Edit Entry")
    model.addAttribute("givenAction", "/entry/" + entryId)
    model.addAttribute("givenTitle", entry.getTitle)
    model.addAttribute("givenContent", entry.getContent)
    "entry"
  }

  @RequestMapping(value = Array("/entry/{id}"), method = Array(RequestMethod.POST))
  def updateEntry(@PathVariable(value = "id") entryId: Long,
                  @RequestParam title: String,
                  @RequestParam content: String): String = {
    val entry = entryRepository.findOne(entryId)
    entry.setTitle(title)
    entry.setContent(content)
    entryRepository.save(entry)
    "redirect:/"
  }

  @RequestMapping(value = Array("/entry/delete/{id}"), method = Array(RequestMethod.GET))
  def deleteEntry(@PathVariable(value = "id") entryId: Long): String = {
    entryRepository.delete(entryId)
    "redirect:/"
  }
}
