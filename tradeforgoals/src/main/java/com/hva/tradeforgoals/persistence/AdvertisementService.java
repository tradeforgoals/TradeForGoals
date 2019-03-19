package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    public Iterable<Advertisement> findAll(){
        Iterable<Advertisement> result = advertisementRepository.findAll();
        return result;
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
