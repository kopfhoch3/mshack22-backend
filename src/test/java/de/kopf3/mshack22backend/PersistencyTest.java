package de.kopf3.mshack22backend;

// import com.vividsolutions.jts.geom.Coordinate;
// import com.vividsolutions.jts.geom.GeometryFactory;
// import de.kopf3.mshack22backend.persistence.document.User;
// import de.kopf3.mshack22backend.repositories.ActivityPointRepository;
import de.kopf3.mshack22backend.persistence.repository.UserRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.ZonedDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersistencyTest {
    // @Autowired
    // private UserRepository userRepository;
    
    // @Autowired
    // private ActivityPointRepository activityPointRepository;

    // @Test
    // void testSaving() {
    //     val user = new User();
    //     user.setNickname("testUser");
    //     user.setDeviceId(UUID.randomUUID());

    //     userRepository.save(user);

    //     val users = userRepository.findAll();
    //     assertThat(users).hasSize(1);
    // }
    
    // @Test
    // void testSavingPoints() {
    //     val user = new User();
    //     user.setNickname("testUesr");
    //     user.setDeviceId(UUID.randomUUID());
        
    //     val point = new Tree();
    //     point.setTitle("My Test Point");
    //     point.setUser(user);
    //     point.setCoordinates(new GeometryFactory().createPoint(new Coordinate(0, 0)));
    //     point.setDescription("asdf");
    //     point.setTimestamp(ZonedDateTime.now());
        
    //     activityPointRepository.save(point);
    // }
}

