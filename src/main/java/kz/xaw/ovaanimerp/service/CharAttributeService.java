package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.CharsAttributeModifier;
import kz.xaw.ovaanimerp.repository.CharAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CharAttributeService {

    private final CharAttributeRepository charAttributeRepository;

    @Autowired
    public  CharAttributeService(CharAttributeRepository abilityRepository) {
        this.charAttributeRepository = abilityRepository;
    }

    @Transactional
    public CharsAttributeModifier findById(Long id) {
        return charAttributeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public List<CharsAttributeModifier> findAll() {
        return charAttributeRepository.findAll();
    }

    @Transactional
    public CharsAttributeModifier save(CharsAttributeModifier charAttribute) {
        return charAttributeRepository.save(charAttribute);
    }

    @Transactional
    public void delete(Long id) {
        charAttributeRepository.deleteById(id);
    }
    @Transactional
    public CharsAttributeModifier update(Long id,CharsAttributeModifier charAttribute){

        Optional<CharsAttributeModifier> CharAttributeOptional = charAttributeRepository.findById(id);

        if (CharAttributeOptional.isPresent()){

            CharsAttributeModifier newCharAttributeModifier = CharAttributeOptional.get();

            newCharAttributeModifier.setLevel(charAttribute.getLevel());
            newCharAttributeModifier.setType(charAttribute.getType());
            newCharAttributeModifier.setCreatedAt(charAttribute.getCreatedAt());
            newCharAttributeModifier.setId(charAttribute.getId());

            newCharAttributeModifier = charAttributeRepository.save(newCharAttributeModifier);

            return newCharAttributeModifier;
        } else {
            charAttribute = charAttributeRepository.save(charAttribute);
        }

        return charAttribute;
    }
}
