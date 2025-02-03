package com.syndicate.app.master.role;

import com.syndicate.app.utility.ConvertToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	IRoleRepo roleRepo;

	@Autowired
	private ConvertToDto convertToDto;

	@Override
	public List<RoleDTO> fetchAllRole() {
		return convertToDto.mapList(roleRepo.findAll(), RoleDTO.class);
	}

}
