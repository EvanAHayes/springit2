package com.ehayes.springit2.Service;

import com.ehayes.springit2.SpringitRepository.RoleRepository;
import com.ehayes.springit2.Springitmodel.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
}
