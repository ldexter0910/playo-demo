package com.playo.demo.services;

import com.playo.demo.entities.Format;
import com.playo.demo.repositories.FormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FormatService {
    @Autowired
    private FormatRepository formatRepository;

    public Format findById(Long id) throws Exception {
        return this.formatRepository.findById(id).orElseThrow(() -> new Exception("Not found"));
    }
}
