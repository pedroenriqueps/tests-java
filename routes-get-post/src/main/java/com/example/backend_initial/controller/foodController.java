package com.example.backend_initial.controller;

import com.example.backend_initial.food.Food;
import com.example.backend_initial.food.FoodRepository;
import com.example.backend_initial.food.FoodRequestDTO;
import com.example.backend_initial.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
public class foodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins =  "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood (@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);

        repository.save(foodData);
        return;
    }

    @GetMapping
    public List<FoodResponseDTO> getAll () {
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).collect(Collectors.toList());

        return foodList;
    }

}
