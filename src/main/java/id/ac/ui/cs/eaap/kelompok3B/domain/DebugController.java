package id.ac.ui.cs.eaap.kelompok3B.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/debug")
public class DebugController 
{
	@RequestMapping()
	public String index()
	{
		return "debug";
	}
}
