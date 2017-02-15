package org.sistema.springmvc.forms.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sistema.springmvc.forms.dao.CiudadDAO;
import org.sistema.springmvc.forms.dao.GenericDAO;
import org.sistema.springmvc.forms.models.Ciudad;
import org.sistema.springmvc.forms.models.Delegacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for users.
 * 
 * @author Eugenia Pérez Martínez
 *
 */
@Controller
public class DelegacionController {
	private static final Logger logger = LoggerFactory.getLogger(DelegacionController.class);

	@Autowired
	private GenericDAO<Delegacion> delegacionDAO;
	@Autowired
	private CiudadDAO ciudadDAO;

	/**
	 * handles /delegaciones/id
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/users/{id}"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/delegaciones/{id}" })
	public String userdelegacionDetail(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
		logger.info("User delegacion detail");

		Delegacion delegacion = delegacionDAO.selectById(id, Delegacion.class);
		model.put("delegacion", delegacion);

		return "delegacion/delegacionDetail";
	}

	/**
	 * handles /users/delegacion/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/users/new"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/delegaciones/new" })
	public ModelAndView createdelegacion(@Valid Delegacion delegacion, BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("ciudad/ciudadDetail");
			modelAndView.addObject("delegacion", delegacion);
			return modelAndView;
		}
		try {
			delegacionDAO.insert(delegacion);
			// We return view name
			modelAndView.setViewName("delegacion/created");
			modelAndView.addObject("delegacion", delegacion);
			logger.info("Saveview POST " + delegacion);
		} catch (Exception e) {
			modelAndView.setViewName("error");
			modelAndView.addObject("error", "An error ocurred while trying to create a new city. Please, try again");
		}
		return modelAndView;
	}

	/**
	 * Simply selects the update view for delegaciones
	 */
	@RequestMapping(value = "/delegaciones/update/{id}", method = RequestMethod.GET)
	public String updatedelegacion(@PathVariable(value = "id") Integer delegacionId, Model model) {
		logger.info("Showing update delegacion view GET ");

		// We find the delegacion through DAO and load into model
		//model.addAttribute("delegacion", delegacionDAO.selectById(delegacionId, Delegacion.class));

		Delegacion delegacion = delegacionDAO.selectById(delegacionId, Delegacion.class);
		List<Ciudad> ciudad = ciudadDAO.selectAll(Ciudad.class);	
		// add to model 
		model.addAttribute("delegacion", delegacion);
		model.addAttribute("ciudad", ciudad);
		
		logger.info("HEre we have: " + ciudad);
		
		
		return "delegacion/update";
	}

	/**
	 * Handles the POST from the Custom.jsp page to update the User.
	 */
	@RequestMapping(value = "/delegaciones/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdatedelegacion(@Valid Delegacion delegacion, BindingResult bindingResult) {
		logger.info("Save update delegacion " + delegacion.getId());
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("delegacion/update");
			modelAndView.addObject("delegacion", delegacion);
			return modelAndView;
		}
		try{
			delegacionDAO.update(delegacion);
			modelAndView.setViewName("delegacion/saveUpdated");
			// We pass the user received through this object
			modelAndView.addObject("delegacion", delegacion);
			
		}catch (Exception e){
			modelAndView.setViewName("error");
			modelAndView
					.addObject("error",
							"An error ocurred while trying to create a new city. Please, try again");
		}
		return modelAndView;
	}

	/**
	 * Delete the specific delegacion
	 */
	@RequestMapping(value = "/delegaciones/delete/{id}", method = RequestMethod.GET)
	public String deletedelegacion(@PathVariable(value = "id") Integer delegacionId, Model model) {
		logger.info("User detail /delete delegacion: " + delegacionId);

		// Store the concrete delegacion to send it back before deleting to use
		// it in
		// the following view.
		Delegacion delegacion = delegacionDAO.selectById(delegacionId, Delegacion.class);
		model.addAttribute("delegacion", delegacion);

		delegacionDAO.delete(delegacion);

		return "delegacion/deleted";
	}

}
