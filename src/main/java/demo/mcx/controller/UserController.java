package demo.mcx.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.mcx.model.AcctUser;
import demo.mcx.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/all")
	public String all(Model model){
		List<AcctUser> users=userService.findAll();
		for(int i=0;i<users.size();i++){
			AcctUser user=users.get(i);
			System.out.println(user.getNickName()+":"+user.getTelephone());
		}
		
		model.addAttribute("users", users);
		return "/index.jsp";
	}
	@RequestMapping("/power")
	public String power(@RequestParam(value="id",defaultValue="null") String id,Model model){
		if(id!=null){
			model.addAttribute("user", userService.power(id));
		}
		return "/index.jsp";
	}
	
	@RequestMapping("/showInfo")
	public String showUserInfo(ModelMap modelMap, @RequestParam(value="id",defaultValue="null") String id){
		LOGGER.info("查询用户：" + id);
		AcctUser userInfo = userService.load(id);
		modelMap.addAttribute("userInfo", userInfo);
		return "/index.jsp";
	}
	
	@RequestMapping("/showInfos")
	public @ResponseBody List<AcctUser> showUserInfos(){
		LOGGER.info("查询用户全部用户");
		List<AcctUser> userInfos = userService.findAll();
		return userInfos;
	}
	
}
