package com.jilnash.hacknu23.controller;

import com.jilnash.hacknu23.model.Operator;
import com.jilnash.hacknu23.repo.OperatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operators")
@CrossOrigin(origins = "*")
public class OperatorController {

    @Autowired
    OperatorRepo operatorRepo;

    @GetMapping
    public List<Operator> getOperators() {

        return operatorRepo.findAll();
    }

    @GetMapping("/{id}")
    public Operator getOperator(@PathVariable Long id) {

        return operatorRepo.getReferenceById(id);
    }

    @PostMapping()
    public void editOperator(@RequestBody Operator operator) {

        operatorRepo.save(operator);
    }

    @DeleteMapping("/{id}")
    public void deleteOperator(@PathVariable Long id) {

        operatorRepo.delete(operatorRepo.getReferenceById(id));
    }
}
