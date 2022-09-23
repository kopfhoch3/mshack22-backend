package de.kopf3.mshack22backend;

import de.kopf3.mshack22backend.entities.User;
import de.kopf3.mshack22backend.repositories.UserRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersistencyTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaving() {
        val user = new User();
        user.setNickname("testUser");
        user.setDeviceId(UUID.randomUUID());

        userRepository.save(user);

        val users = userRepository.findAll();
        assertThat(users).hasSize(1);
    }
}

