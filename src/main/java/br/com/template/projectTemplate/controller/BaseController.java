/**
 * Abstract class extended by the controllers in order to keep the common functions for the controllers 
 * */
package br.com.template.projectTemplate.controller;

import br.com.template.projectTemplate.service.BaseService;

public abstract class BaseController<T> {

	public abstract BaseService<T> getService();
	
}
