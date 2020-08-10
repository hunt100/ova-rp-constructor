package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.Ability;
import kz.xaw.ovaanimerp.repository.AbilityRepository;
import kz.xaw.ovaanimerp.service.mapper.AbilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AbilityService {

    private final AbilityRepository abilityRepository;
    private final AbilityMapper abilityMapper;

    @Autowired
    public AbilityService(AbilityRepository abilityRepository, AbilityMapper abilityMapper) {
        this.abilityRepository = abilityRepository;
        this.abilityMapper = abilityMapper;
    }

    @Transactional
    public Ability findById(Long id) {
        return abilityRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public List<Ability> findAll() {
        return abilityRepository.findAll();
    }

    @Transactional
    public Ability save(Ability ability) {
        return abilityRepository.save(ability);
    }

    @Transactional
    public void delete(Long id) {
        abilityRepository.deleteById(id);
    }

    @Transactional
    public Ability update(Long id,Ability ability) throws RuntimeException {

        Optional<Ability> abilityOptional = abilityRepository.findById(id);

            Ability newAbility = abilityOptional.get();

            newAbility.setDescription(ability.getDescription());
            newAbility.setLevel(ability.getLevel());
            newAbility.setName(ability.getName());
            newAbility.setModifierList(ability.getModifierList());

            newAbility = abilityRepository.save(newAbility);

            return newAbility;
    }
}