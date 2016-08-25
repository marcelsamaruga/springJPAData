/**
 * @name: OfMateriaPrimaController
 * */
package br.com.template.projectTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.template.projectTemplate.entity.OfMateriaPrima;
import br.com.template.projectTemplate.service.OfMateriaPrimaService;

@Controller
public class OfMateriaPrimaController extends BaseController<OfMateriaPrima> {

	@Autowired
	OfMateriaPrimaService service;
	
	@Override
	public OfMateriaPrimaService getService() {
		return service;
	}

}
