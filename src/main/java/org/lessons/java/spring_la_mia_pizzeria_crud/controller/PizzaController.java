package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(Model model) {
        // prendo tutte le pizza dalle repository
        List<Pizza> pizzas = repository.findAll();
        // passo le pizze con model
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable Integer id) {
        // prendo tutte le pizza dalle repository
        List<Pizza> pizzas = repository.findAll();
        Pizza foundPizza = null;

        for (Pizza pizza : pizzas) {
            if (pizza.getId().equals(id)) {
                foundPizza = pizza;
            }
        }
        // passo la pizza con model
        model.addAttribute("pizza", foundPizza);
        return "pizzas/show";
    }
}
