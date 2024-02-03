package com.laurentius.phonebook.controller;

import com.laurentius.phonebook.interfaceadapter.ContactDataMapper;
import com.laurentius.phonebook.interfaceadapter.JpaContactRepository;
import com.laurentius.phonebook.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

    @Autowired
    private JpaContactRepository repository;

    @RequestMapping(value={"/index"}, method= RequestMethod.GET)
    public String showContactList(ModelMap model) {
        model.addAttribute("contacts", repository.findAll());
        return "index";
    }

    @RequestMapping(value={"/create"}, method= RequestMethod.GET)
    public String showContactUpdate(ModelMap model) {
        model.addAttribute("contact", new ContactDataMapper());
        return "contact-create";
    }

    @RequestMapping(value={"/create"}, method= RequestMethod.POST)
    public String createContact(ModelMap model, @ModelAttribute("contact") ContactDataMapper contact) {
        if (StringUtil.isBlank(contact.getName())) {
            model.addAttribute("errorMsg", "Name cannot be empty");
            return "contact-create";
        }
        repository.save(contact);
        return "redirect:/index";
    }

    @RequestMapping(value={"/read/{id}"}, method= RequestMethod.GET)
    public String showContact(ModelMap model, @PathVariable(value = "id") Long id) {
        repository.findById(id);
        return "contact-details";
    }

    @RequestMapping(value={"/update/{id}"}, method= RequestMethod.GET)
    public String showContactUpdate(ModelMap model, @PathVariable(value = "id") Long id) {
        ContactDataMapper contact = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact ID:" + id));

        model.addAttribute("contact", contact);
        System.out.println("showContactUpdate: " + contact.getId());
        return "contact-update";
    }

    @RequestMapping(value={"/update"}, method= RequestMethod.POST)
    public String updateContactById(ModelMap model, @ModelAttribute("contact") ContactDataMapper contact) {
        System.out.println("updateContactById: " + contact.getId());
        System.out.println("updateContactById: " + contact.getName());
        if (contact.getId() == null) {
            System.out.println("contact.getId() null");
            model.addAttribute("errorMsg", "Contact ID cannot be empty");
            return "contact-update";
        }
        System.out.println("contact.getId() ok");
        if (StringUtil.isBlank(contact.getName())) {
            System.out.println("contact.getName() null/blank");
            model.addAttribute("errorMsg", "Name cannot be empty");
            return "contact-update/";
        }
        System.out.println("contact.getName() ok, updating contact...");
        repository.save(contact);
        return "redirect:/index";
    }

    @RequestMapping(value={"/delete/{id}"}, method= RequestMethod.GET)
    public String deleteContactById(ModelMap model, @PathVariable(value = "id") Long id) {
        System.out.println("deleteContactById: " + id);
        repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact ID:" + id));
        System.out.println("deleteContactById: " + id);
        System.out.println("contact.getName() ok, updating contact...");
        repository.deleteById(id);
        return "redirect:/index";
    }
}
