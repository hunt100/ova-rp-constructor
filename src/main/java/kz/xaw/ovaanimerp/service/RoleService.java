package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.repository.RoleRepository;
import kz.xaw.ovaanimerp.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException("Exception"));
    }
}
