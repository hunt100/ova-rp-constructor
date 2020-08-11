package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.Attack;
import kz.xaw.ovaanimerp.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AttackService {

    private final AttackRepository attackRepository;

    @Autowired
    public AttackService(AttackRepository attackRepository) {
        this.attackRepository = attackRepository;
    }

    @Transactional
    public Attack findById(Long id) {
        return attackRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public List<Attack> findAll() {
        return attackRepository.findAll();
    }

    @Transactional
    public Attack save(Attack Attack) {
        return attackRepository.save(Attack);
    }

    @Transactional
    public void delete(Long id) {
        attackRepository.deleteById(id);
    }

    @Transactional
    public Attack update(Long id,Attack attack) throws RuntimeException {

        Optional<Attack> AttackOptional = attackRepository.findById(id);

        if (AttackOptional.isPresent()) {

            Attack newAttack = AttackOptional.get();

            newAttack.setDescription(attack.getDescription());
            newAttack.setDx(attack.getDx());
            newAttack.setEnd(attack.getEnd());
            newAttack.setName(attack.getName());
            newAttack.setPerksAndFlows(attack.getPerksAndFlows());
            newAttack.setRoll(attack.getRoll());
            newAttack.setCreatedAt(attack.getCreatedAt());
            newAttack.setId(attack.getId());

            newAttack = attackRepository.save(newAttack);

            return newAttack;
        } else {
            attack = attackRepository.save(attack);

            return attack;
        }
    }
}