package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.Weakness;
import kz.xaw.ovaanimerp.repository.WeaknessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WeaknessService {

    private final WeaknessRepository weaknessRepository;

    @Autowired
    public WeaknessService(WeaknessRepository WeaknessRepository) {
        this.weaknessRepository = WeaknessRepository;
    }

    @Transactional
    public Weakness findById(Long id) {
        return weaknessRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public List<Weakness> findAll() {
        return weaknessRepository.findAll();
    }

    @Transactional
    public Weakness save(Weakness Weakness) {
        return weaknessRepository.save(Weakness);
    }

    @Transactional
    public void delete(Long id) {
        weaknessRepository.deleteById(id);
    }

    @Transactional
    public Weakness update(Long id,Weakness weakness) throws RuntimeException {

        Optional<Weakness> weaknessOptional = weaknessRepository.findById(id);

        if (weaknessOptional.isPresent()) {

            Weakness newWeakness = weaknessOptional.get();

            newWeakness.setDescription(weakness.getDescription());
            newWeakness.setLevel(weakness.getLevel());
            newWeakness.setModifierList(weakness.getModifierList());
            newWeakness.setName(weakness.getName());
            newWeakness.setCreatedAt(weakness.getCreatedAt());
            newWeakness.setId(weakness.getId());

            newWeakness = weaknessRepository.save(newWeakness);

            return newWeakness;
        } else {
            weakness = weaknessRepository.save(weakness);

            return weakness;
        }
    }
}