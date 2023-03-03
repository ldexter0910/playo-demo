package com.playo.demo.services;

import com.playo.demo.entities.Sport;
import com.playo.demo.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SportService {
    @Autowired
    private final SportRepository sportRepository = null;

    public List<Sport> getSports() throws Exception {
        return this.sportRepository.findAll();
    }

    public Sport getSportDetails(Long id) throws Exception {
        Sport sport = this.sportRepository.findById(id).orElse(null);
        if(sport == null) {
            throw new Exception("Resource not found");
        }
        return sport;
    }
}
