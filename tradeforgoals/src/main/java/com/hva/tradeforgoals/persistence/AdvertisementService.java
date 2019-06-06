package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Advertisement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdvertisementService {

    private AdvertisementRepository advertisementRepository;

    public void setAdvertisementRepository(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    public Iterable<Advertisement> findAll(){
        return advertisementRepository.findAll();
    }

    public Advertisement findById(long id){
        Optional<Advertisement> advertisement = advertisementRepository.findById(id);

        return advertisement.orElse(null);
    }

    public Advertisement save(Advertisement advertisement){
        return advertisementRepository.save(advertisement);
    }

    public void deleteById(long id) {
        advertisementRepository.deleteById(id);
    }

}
