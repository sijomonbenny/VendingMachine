/* Name of the Author : SIJOMON BENNY
 * Department         : MCA
 * E-mail			  : sijomonbenny@outlook.com
 * Date of Modified   : 29/09/2020
 */
/* Class Name : Home Controller
 * Purpose : This class act as controller to get and process requests from client
 */

package com.baton.vm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baton.vm.model.Inventory;
import com.baton.vm.model.Item;
import com.baton.vm.repository.VendingMachineRepository;

@Controller
public class HomeController {

	@Autowired
	VendingMachineRepository vmRepo;
	double total;

	// This method will return all the items stored in the database
	@RequestMapping("/")
	public ModelAndView home() {
		total = 0;
		ModelAndView mv = new ModelAndView();
		mv.addObject("inventories", vmRepo.findAll());
		mv.addObject("total", total);
		mv.setViewName("home");
		return mv;
	}

	// Method for buy new Items
	@RequestMapping(value = "/buyItem")
	public ModelAndView buyItem(@RequestParam(name = "selectedItems") String[] items) {
		total = 0;
		ArrayList<Item> cart = new ArrayList<Item>();
		ModelAndView mv = new ModelAndView();
		for (int i = 0; i < items.length; i++) {
			Inventory item = vmRepo.findById((Integer.parseInt(items[i]))).orElse(null);
			cart.add(item.getItem());
			total += item.getItem().getPrice();
			vmRepo.updateStock(Integer.parseInt(items[i]));
			mv.addObject("total", total);
		}
		mv.setViewName("home");
		mv.addObject("inventories", vmRepo.findAll());
		return mv;
	}

}
