package com.JavaBootcamp03.mobilestore.controller;

import com.JavaBootcamp03.mobilestore.payload.response.ApiResponse;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.JavaBootcamp03.mobilestore.dto.RoleDTO;
import com.JavaBootcamp03.mobilestore.entity.RoleEntity;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.RoleServiceImp;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceImp roleServiceImp;

    @Autowired
    private ModelMapper modelMapper;

    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    public RoleController(RoleServiceImp roleServiceImp) {
        super();
        this.roleServiceImp = roleServiceImp;
    }

    @GetMapping("/list")
    public List<RoleDTO> getRoles(){
        logger.info("Roles are retrieved");
        return roleServiceImp.getAllRole()
                .stream().map(roleList -> modelMapper.map(roleList, RoleDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable(name ="id") int id){
        logger.info("Role is retrieved");
        RoleEntity roleEntity = roleServiceImp.getRoleById(id);

        RoleDTO roleDTO = modelMapper.map(roleEntity, RoleDTO.class);

        return ResponseEntity.ok().body(roleDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {
        logger.info("Role is created");
        RoleEntity roleEntity = roleServiceImp.createRole(roleDTO);

        RoleDTO roleDTOResponse = modelMapper.map(roleEntity, RoleDTO.class);

        return new ResponseEntity<RoleDTO>(roleDTOResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable(name = "id") int id, @RequestBody RoleDTO roleDTO) {
        logger.info("Role is updated");
        RoleEntity roleEntity = roleServiceImp.updateRole(id, roleDTO);

        RoleDTO roleDTOResponse = modelMapper.map(roleEntity, RoleDTO.class);

        return new ResponseEntity<RoleDTO>(roleDTOResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRole(@PathVariable(name = "id") int id) {
        logger.info("Role is deleted");

        roleServiceImp.deleteRole(id);

        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, 200, "Role is deleted successfully","");

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}
