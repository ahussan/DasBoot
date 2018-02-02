package com.boot.controller;

import com.boot.model.Shipwreck;
import com.boot.repository.IShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anjalhussan on 1/30/18.
 */

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

    @Autowired
    private IShipwreckRepository shipwreckRepository;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list(){
        return shipwreckRepository.findAll();
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck){
        return shipwreckRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable long id){
        return shipwreckRepository.findOne(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable long id, @RequestBody Shipwreck shipwreck){
        Shipwreck existingShipWreck = shipwreckRepository.findOne(id);
        BeanUtils.copyProperties(shipwreck, existingShipWreck);
        return shipwreckRepository.saveAndFlush(existingShipWreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable long id){
        Shipwreck existingShipWreck = shipwreckRepository.findOne(id);
        shipwreckRepository.delete(existingShipWreck);
        return existingShipWreck;
    }
}
