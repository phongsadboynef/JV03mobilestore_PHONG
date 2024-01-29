package com.JavaBootcamp03.mobilestore.service;

import com.JavaBootcamp03.mobilestore.dto.RoleDTO;
import com.JavaBootcamp03.mobilestore.entity.RoleEntity;
import com.JavaBootcamp03.mobilestore.repository.RoleRepository;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.RoleServiceImp;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class RoleService implements RoleServiceImp {
    @Autowired
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        super();
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleEntity> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity createRole(RoleDTO roleDTO) {
        RoleEntity role = new RoleEntity();

        role.setName(roleDTO.getName());

        return roleRepository.save(role);
    }

    @Override
    public RoleEntity updateRole(int id, RoleDTO roleDTO) {
        RoleEntity roleEntity = roleRepository.findById(id);

        if (roleEntity != null) {
            roleEntity.setName(roleDTO.getName());
            return roleRepository.save(roleEntity);
        }

        return null;
    }

    @Override
    public void deleteRole(int id) {
        RoleEntity roleEntity = roleRepository.findById(id);

        if (roleEntity != null) {
            roleRepository.delete(roleEntity);
        }
    }

    @Override
    public RoleEntity getRoleById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public RoleEntity getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
