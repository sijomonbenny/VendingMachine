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

import com.baton.vm.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("inventory_service")
    private VendingMachineService vmService;
    ArrayList<Item> cart = new ArrayList<>();

    // This method will return all the items stored in the database
    @RequestMapping("/")
    public ModelAndView home() {
        double total;
        ModelAndView mv = new ModelAndView();
        mv.addObject("inventories", vmService.getAllItems());
        total = cart.size();
        mv.addObject("total", total);
        mv.setViewName("home");
        return mv;
    }

    // Method for buy new Items
    @RequestMapping(value = "/buyItem")
    public ModelAndView buyItem(@RequestParam(name = "selectedItems") String[] items) {
        double total = 0;
        ModelAndView mv = new ModelAndView();
        for (String itemID : items) {
            Inventory item = vmService.getItemById(Integer.parseInt(itemID));
            assert item != null;
            cart.add(item.getItem());
            total += item.getItem().getPrice();
            vmService.updateStock(Integer.parseInt(itemID));
            mv.addObject("total", total);
        }
        mv.setViewName("home");
        mv.addObject("inventories", vmService.getAllItems());
        return mv;
    }

}
