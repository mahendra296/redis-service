package com.redis.service;

import com.redis.dto.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final RedisRepository redisRepository;

    public void savePerson(PersonDTO personDTO) {
        redisRepository.setValue(personDTO.getKey(), personDTO.getValue());
    }

    public String getPerson(String key) {
        String value = (String) redisRepository.getValue(key);
        return value;
    }
}
