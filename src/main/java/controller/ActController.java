package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.inter.IAccountDao;
import entity.Account;

/**
 * 账户控制器
 * @author GLL
 *
 */

@Controller
@RequestMapping("/act")
public class ActController {
	
	@Autowired
	private IAccountDao actDao;

	@RequestMapping("/toAdd")
	public ModelAndView toAdd() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("account/add");
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add(Account act) {
		ModelAndView mv = new ModelAndView();
		try {
			actDao.saveOrUpdate(act);
			mv.setViewName("account/addSuccess");
		}catch(Exception e) {
			mv.setViewName("account/addFailure");
			e.printStackTrace();
		}
		return mv;
		
	}
	
	public void update() {}
	
	public void delete() {}
	
}
