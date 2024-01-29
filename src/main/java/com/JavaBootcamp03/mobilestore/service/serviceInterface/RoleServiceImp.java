package com.JavaBootcamp03.mobilestore.service.serviceInterface;

import com.JavaBootcamp03.mobilestore.dto.RoleDTO;
import com.JavaBootcamp03.mobilestore.entity.RoleEntity;
import java.util.List;

public interface RoleServiceImp {
    List<RoleEntity> getAllRole();

    RoleEntity createRole(RoleDTO roleDTO);

    RoleEntity updateRole(int id, RoleDTO roleDTO);

    void deleteRole(int id);

    RoleEntity getRoleById(int id);

    RoleEntity getRoleByName(String name);
}
