package com.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.javabean.leaseinformation;
import com.service.LeaseinformationService;

/**
 * 房屋信息控制器
 * @author Administrator
 *
 */
 
@Controller
@RequestMapping("/leaseinformationmvc")
public class LeaseinformationController {
    @Autowired
    LeaseinformationService leaseinformationService;
        
    @RequestMapping("/details")
    public ModelAndView listCategory(@RequestParam int id){
        ModelAndView mav = new ModelAndView("details");
        List<leaseinformation> cs= leaseinformationService.allANDimg1(id);
        for (leaseinformation leaseinformation : cs) {
			System.out.println(leaseinformation.getLeaseimg().getImgroute());
		}
        // 放入转发参数
        mav.addObject("cs", cs);
        return mav;
    }
 
}