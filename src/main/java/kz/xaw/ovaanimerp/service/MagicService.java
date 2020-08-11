package kz.xaw.ovaanimerp.service;

import kz.xaw.ovaanimerp.data.Magic;
import kz.xaw.ovaanimerp.repository.MagicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MagicService {

    private final MagicRepository magicRepository;

    @Autowired
    public MagicService(MagicRepository MagicRepository) {
        this.magicRepository = MagicRepository;
    }

    @Transactional
    public Magic findById(Long id) {
        return magicRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public List<Magic> findAll() {
        return magicRepository.findAll();
    }

    @Transactional
    public Magic save(Magic Magic) {
        return magicRepository.save(Magic);
    }

    @Transactional
    public void delete(Long id) {
        magicRepository.deleteById(id);
    }

    @Transactional
    public Magic update(Long id,Magic magic) throws RuntimeException {

        Optional<Magic> magicOptional = magicRepository.findById(id);

        if (magicOptional.isPresent()) {

            Magic newMagic = magicOptional.get();

            newMagic.setBaseEnduranceCost(magic.getBaseEnduranceCost());
            newMagic.setEffect(magic.getEffect());
            newMagic.setSpellLevel(magic.getSpellLevel());
            newMagic.setSpellName(magic.getSpellName());
            newMagic.setCreatedAt(magic.getCreatedAt());
            newMagic.setId(magic.getId());

            newMagic = magicRepository.save(newMagic);

            return newMagic;
        } else {
            magic = magicRepository.save(magic);

            return magic;
        }
    }
}