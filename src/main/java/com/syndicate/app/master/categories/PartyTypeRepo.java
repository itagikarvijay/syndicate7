package com.syndicate.app.master.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyTypeRepo extends  JpaRepository<PartyType, Long> {

}
