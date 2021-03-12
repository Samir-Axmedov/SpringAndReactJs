package com.aptek.pharm.Service;

import com.aptek.pharm.entity.Hoaxy;
import org.springframework.stereotype.Service;
import com.aptek.pharm.Respository.*;



@Service
public class HoaxyService {

    hoaxyRepository hoaxyRepository;

    public HoaxyService(com.aptek.pharm.Respository.hoaxyRepository hoaxyRepository) {
        super();
        this.hoaxyRepository = hoaxyRepository;
    }

    public void save(Hoaxy hoaxy) {
        hoaxyRepository.save(hoaxy);
    }
}
