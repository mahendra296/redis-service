package com.redis.controller;

import com.redis.dto.PersonDTO;
import com.redis.service.TestService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello");
    }

    @PostMapping("/person")
    public ResponseEntity<String> savePerson(@RequestBody PersonDTO personDTO) {
        testService.savePerson(personDTO);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/person")
    public ResponseEntity<String> getPerson(@RequestParam("key") String key) {
        return ResponseEntity.ok(testService.getPerson(key));
    }
}
