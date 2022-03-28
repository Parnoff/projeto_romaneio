package projeto.romaneio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import projeto.romaneio.model.Cliente;
import projeto.romaneio.repository.ClienteRepository;
import java.util.Optional;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastrarcliente")
	public ModelAndView inicio() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastrocliente");
		modelAndView.addObject("clienteobj", new Cliente());
		Iterable<Cliente> clientesIt = clienteRepository.findAll();
		modelAndView.addObject("clientes", clientesIt);
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listarcliente")
	public ModelAndView listarCliente() {
		ModelAndView modelAndView = new ModelAndView("cadastro/listarcliente");
		//modelAndView.addObject("clienteobj", new Cliente());
		Iterable<Cliente> clientesIt = clienteRepository.findAll();
		modelAndView.addObject("clientes", clientesIt);
		return modelAndView;
	}	
	
	@RequestMapping(method = RequestMethod.POST, value  = "/salvarcliente/**")
	public ModelAndView salvar(Cliente cliente) {
		
		clienteRepository.save(cliente);

		ModelAndView andView = new ModelAndView("cadastro/listarcliente");
		Iterable<Cliente> clientesIt = clienteRepository.findAll();
		andView.addObject("clientes", clientesIt);
		andView.addObject("clienteobj", new Cliente());
			
		return andView;
	}
	
	@GetMapping("/editarcliente/{idcliente}")
	public ModelAndView editar(@PathVariable("idcliente") Long idcliente) {
		
		Optional<Cliente> cliente = clienteRepository.findById(idcliente);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastrocliente");
		modelAndView.addObject("clienteobj", cliente.get());
		return modelAndView;
		
	}
	
	@GetMapping("/excluircliente/{idcliente}")
	public ModelAndView excluir(@PathVariable("idcliente") Long idcliente) {
		
		clienteRepository.deleteById(idcliente);	
		
		ModelAndView modelAndView = new ModelAndView("cadastro/listarcliente");
		/*modelAndView.addObject("cleintes", clienteRepository.findAll());
		modelAndView.addObject("clienteobj", new Cliente());
		return modelAndView;*/
		
		Iterable<Cliente> clientesIt = clienteRepository.findAll();
		modelAndView.addObject("clientes", clientesIt);
		return modelAndView;	
	}
}
