/**
 * 
 */
package org.sistema.springmvc.forms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.sistema.springmvc.forms.models.Ciudad;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * implementation of ProductDAO
 * 
 * @author Eugenia Pérez Martínez
 * @email eugenia_perez@cuatrovientos.org
 *
 */

public class CiudadDAO extends GenericDAO<Ciudad> {


		/**
	 * Selects all product types by name
	 * 
	 * @return List of products
	 */
	@Transactional(readOnly = true)
	public List<Ciudad> selectByName(String name) {

		List<Ciudad> products = null;

			Query query = getSession()
							.createQuery("from ciudad u where u.nombre LIKE :nombre");
		    query.setParameter("nombre", "%"+name+"%");
		    
			// We get a generic object list
			products = query.list();

		return products;
	}

}
