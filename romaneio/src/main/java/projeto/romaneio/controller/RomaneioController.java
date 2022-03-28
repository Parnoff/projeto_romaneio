package projeto.romaneio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import projeto.romaneio.model.Romaneio;
import projeto.romaneio.repository.RomaneioRepository;

@Controller
public class RomaneioController {
	
	@Autowired
	private RomaneioRepository romaneioRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadromaneio")
	public ModelAndView inicio() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadromaneio");
		modelAndView.addObject("romaneioobj", new Romaneio());
		Iterable<Romaneio> romaneiosIt = romaneioRepository.findAll();
		modelAndView.addObject("romaneios", romaneiosIt);
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value  = "/salvarromaneio/**")
	public ModelAndView salvar(Romaneio romaneio) {
		
		romaneioRepository.save(romaneio);

		ModelAndView andView = new ModelAndView("cadastro/listarroma");
		Iterable<Romaneio> romaneiosIt = romaneioRepository.findAll();
		andView.addObject("romaneios", romaneiosIt);
		andView.addObject("romaneioobj", new Romaneio());
			
		return andView;	
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/listarroma")
	public ModelAndView listarRomaneio(Romaneio romaneio) {
		ModelAndView modelAndView = new ModelAndView("cadastro/listarroma");
		//modelAndView.addObject("romaneioobj", new Romaneio());
		Iterable<Romaneio> romaneiosIt = romaneioRepository.findAll();
		modelAndView.addObject("romaneios", romaneiosIt);
		return modelAndView;
	}	
}
