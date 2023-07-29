package com.controller;

import com.model.Resource;
import com.view.ResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger((ResourceManagementController.class));
    @Autowired
    ResourceRepository resourceRepository;

    @GetMapping("")
    public List<Resource> getAll(){
        return resourceRepository.getAll();
    }

    @GetMapping("/{id}")
    public Resource getById(@PathVariable("id")int id){
        return resourceRepository.getById(id);
    }

    @PostMapping("")
    public void add(@RequestBody List<Resource> resources){
        resourceRepository.save(resources);
    }


    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Resource updatedResource){
        Resource resource = resourceRepository.getById(id);

        if(resource !=null){
            resource.setName(updatedResource.getName());
            resource.setComment(updatedResource.getComment());
            resourceRepository.update(resource);
            return 1;
        }else{
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Resource updatedResource){
        Resource resource = resourceRepository.getById(id);
        if(resource !=null){
            if(updatedResource.getName() !=null) resource.setName(updatedResource.getName());
            if(updatedResource.getComment() !=null) resource.setComment(updatedResource.getComment());

            resourceRepository.update(resource);
            return 1;
        }else{
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id")int id){
        return resourceRepository.delete(id);
    }

    }
