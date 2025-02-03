package com.syndicate.app.master.categories;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;


@Entity
@DiscriminatorValue("DEPT_TYPE")
public class Department extends Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}