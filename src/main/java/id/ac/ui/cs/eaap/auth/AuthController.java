package id.ac.ui.cs.eaap.auth;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController 
{
	@RequestMapping()
	public String defaultSuccessLogin(Model model, Authentication auth, Principal p)
	{		
		return "home";
	}
	
	@RequestMapping("403")
	public String accessDenied()
	{
		return "403";
	}
	
	@RequestMapping("/login")
	public String login(Authentication auth)
	{
		if (auth != null && auth.isAuthenticated())
			return "redirect:/";
		
		return "login";
	}
}
