package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.Ability;
import kz.xaw.ovaanimerp.repository.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AbilityService {

    private final AbilityRepository abilityRepository;

    @Autowired
    public AbilityService(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
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
    public Ability update(Ability ability) throws RuntimeException {

        Optional<Ability> abilityOptional = abilityRepository.findById(id);

        if (abilityOptional.isPresent()) {

            Ability newAbility = abilityOptional.get();

            newAbility.setDescription(ability.getDescription());
            newAbility.setLevel(ability.getLevel());
            newAbility.setName(ability.getName());
            newAbility.setModifierList(ability.getModifierList());

            newAbility = abilityRepository.save(newAbility);

            return newAbility;
        } else {
            ability = abilityRepository.save(ability);

            return ability;
        }
    }
}

//  UPDATE