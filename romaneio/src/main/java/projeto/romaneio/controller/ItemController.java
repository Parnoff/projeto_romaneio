package projeto.romaneio.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import projeto.romaneio.model.Item;
import projeto.romaneio.repository.ItemRepository;


@Controller
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastraritem")
	public ModelAndView inicio() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroitem");
		modelAndView.addObject("itemobj", new Item());
		Iterable<Item> itensIt = itemRepository.findAll();
		modelAndView.addObject("itens", itensIt);
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listaritem")
	public ModelAndView listarItem() {
		ModelAndView modelAndView = new ModelAndView("cadastro/listaritem");
		//modelAndView.addObject("itemobj", new Item());
		Iterable<Item> itensIt = itemRepository.findAll();
		modelAndView.addObject("itens", itensIt);
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value  = "/salvaritem/**")
	public ModelAndView salvar(Item item) {
		
		itemRepository.save(item);

		ModelAndView andView = new ModelAndView("cadastro/listaritem");
		Iterable<Item> itensIt = itemRepository.findAll();
		andView.addObject("itens", itensIt);
		andView.addObject("itemobj", new Item());
			
		return andView;
		
	}
	
	@GetMapping("/editaritem/{iditem}")
	public ModelAndView editar(@PathVariable("iditem") Long iditem) {
		
		Optional<Item> item = itemRepository.findById(iditem);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastroitem");
		modelAndView.addObject("itemobj", item.get());
		return modelAndView;
		
	}
	
	@GetMapping("/excluiritem/{iditem}")
	public ModelAndView excluir(@PathVariable("iditem") Long iditem) {
		
		itemRepository.deleteById(iditem);	
		
		ModelAndView modelAndView = new ModelAndView("cadastro/listaritem");
		/*modelAndView.addObject("itens", itemRepository.findAll());
		modelAndView.addObject("itemobj", new Item());
		return modelAndView;*/
		
		Iterable<Item> itensIt = itemRepository.findAll();
		modelAndView.addObject("itens", itensIt);
		return modelAndView;	
	}
}
