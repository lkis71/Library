package com.example.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.controller.dto.RentalDto;
import com.example.book.entity.Rental;
import com.example.book.service.RentalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RentalController {
    
    private final RentalService rentalService;

    @GetMapping("/rental")
    public Map<String, Object> getRental(Model model) {
        List<Rental> rentals = rentalService.getRental();
        List<RentalDto> rentalDtos = rentals.stream()
            .map(o -> new RentalDto(o))
            .collect(Collectors.toList());

        Map<String, Object> result = new HashMap<>();
        result.put("data", rentalDtos);
        return result;
    }

    @PostMapping("/rental")
    public Long rentalBook(@RequestParam("userId") Long userId, @RequestParam("bookId") Long bookId) {
        return rentalService.rental(userId, bookId);
    }
}
