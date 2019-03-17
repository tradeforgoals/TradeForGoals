package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Lid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LedenService {

    @Autowired
    private LedenRepository ledenRepository;

    public Iterable<Lid> findAll(){
        Iterable<Lid> result = ledenRepository.findAll();
        return result;
    }

    public Lid findById(long id){
        Optional<Lid> lid = ledenRepository.findById(id);

        if (lid.isPresent()) {
            return lid.get();
        }else{
            return null;
        }
    }

    public Lid save(Lid lid) {
        return ledenRepository.save(lid);
    }
}

