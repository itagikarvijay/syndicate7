package com.syndicate.app.master.categories;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
@DiscriminatorValue("PARTY_TYPE")
public class PartyType extends Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
