package com.gc.hibernate.Lab24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.hibernate.Lab24.dao.ItemDao;
import com.gc.hibernate.Lab24.dao.UserDao;
import com.gc.hibernate.Lab24.entity.Item;


@Controller
public class HomeController {

	@Autowired
	UserDao u;

	@Autowired
	ItemDao i;

	@RequestMapping("/")
	public ModelAndView index() {

		System.out.println(i.findAll());
		return new ModelAndView("index", "list", i.findAll());
	}

	@RequestMapping("/search") // this is the "form action="search"
	public ModelAndView search(@RequestParam("id") int id) {
		Item i1 = i.findById(id);

		System.out.println(i1);
		if (i == null) {
			return new ModelAndView("search", "item", "That item does not exist!");
		}

		return new ModelAndView("search", "item", i1);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("quantity") int quantity, @RequestParam("price") double price) {
		Item i1 = new Item(name, description, quantity, price);
		i.update(i1);
		return new ModelAndView("update", "item", i1);
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(@RequestParam("id") int id) {
		i.deleteById(id);
		return new ModelAndView("index", "list", i.findAll());
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam("id") int id) {
		return new ModelAndView("formupdate", "id", id);
	}
	
	@RequestMapping(value = "updateitem", method = RequestMethod.POST)
	public ModelAndView updatePerson(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("quantity") int quantity, @RequestParam("price") double price) {
		Item i1 = new Item(id, name, description, quantity, price);
		i.update(i1);
		return new ModelAndView("index", "list", i.findAll());
	}

}
