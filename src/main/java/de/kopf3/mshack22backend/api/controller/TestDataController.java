package de.kopf3.mshack22backend.api.controller;

import de.kopf3.mshack22backend.persistence.document.Action;
import de.kopf3.mshack22backend.persistence.document.ActivityPoint;
import de.kopf3.mshack22backend.persistence.document.Image;
import de.kopf3.mshack22backend.persistence.document.User;
import de.kopf3.mshack22backend.persistence.repository.ActivityPointRepository;
import de.kopf3.mshack22backend.persistence.repository.TreePointRepository;
import de.kopf3.mshack22backend.persistence.repository.UserRepository;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class TestDataController {
    private final ActivityPointRepository activityPointRepository;
    private final TreePointRepository treePointRepository;
    private final UserRepository userRepository;

    public TestDataController(ActivityPointRepository activityPointRepository, TreePointRepository treePointRepository, UserRepository userRepository) {
        this.activityPointRepository = activityPointRepository;
        this.treePointRepository = treePointRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public void resetToTestData(){
        activityPointRepository.deleteAll();
        userRepository.deleteAll();
        User user = insertUser();
        insertActivityPoints(user.getId());
    }


    private void insertActivityPoints(String userId) {
        ActivityPoint gift = new ActivityPoint();
        gift.setLocation(new Point(51.95225897421028, 7.640386031636531));
        gift.setTitle("Hier gibts Merge!");
        gift.setDescription("Echt coole Socken, Shirts und Hoodies!");
        gift.setResolved(false);
        gift.setActions(Collections.emptyList());
        Image hub = new Image();
        hub.setPrimary(true);
        hub.setUrl("https://www.digitalhub.ms/img/coworking/muenster_05.jpg");
        gift.setImages(List.of(hub));
        gift.setType("gift");
        gift.setTimestamp(new Date());
        gift.setUserId(userId);

        ActivityPoint wastePointOpen = new ActivityPoint();
        wastePointOpen.setLocation(new Point(51.95094901831947, 7.637933852966046));
        wastePointOpen.setTitle("Hier liegt Müll!");
        wastePointOpen.setDescription("Immer das selbe an dieser Stelle...");
        wastePointOpen.setResolved(false);
        wastePointOpen.setActions(Collections.emptyList());
        Image image = new Image();
        image.setPrimary(true);
        image.setUrl("https://cdn.pixabay.com/photo/2017/06/18/17/58/garbage-2416624_960_720.jpg");
        wastePointOpen.setImages(List.of(image));
        wastePointOpen.setType("wastecare");
        wastePointOpen.setTimestamp(new Date());
        wastePointOpen.setUserId(userId);

        ActivityPoint wastePointResolved = new ActivityPoint();
        wastePointResolved.setLocation(new Point(51.952197878767734, 7.6391023718815525));
        wastePointResolved.setTitle("Hier liegt Müll!");
        wastePointResolved.setDescription("Immer das selbe an dieser Stelle...");
        wastePointResolved.setResolved(true);
        wastePointResolved.setActions(Collections.emptyList());
        wastePointResolved.setImages(List.of(image));
        wastePointResolved.setType("wastecare");
        wastePointResolved.setTimestamp(Date.from(Instant.ofEpochMilli(new Date().getTime()-86400000L)));
        wastePointResolved.setUserId(userId);

        Action wasteCare = new Action();
        wasteCare.setMessage("Ich hab aufgeräumt!");
        wasteCare.setType("wastecare");
        wasteCare.setTimestamp(new Date());
        Image clean = new Image();
        clean.setPrimary(true);
        clean.setUrl("https://cdn.pixabay.com/photo/2020/11/03/21/09/grass-5710955_960_720.jpg");
        wasteCare.setImages(List.of(clean));

        wastePointResolved.setActions(List.of(wasteCare));

        activityPointRepository.save(wastePointOpen);
        activityPointRepository.save(wastePointResolved);
        activityPointRepository.save(gift);



    }
    private User insertUser(){
        User user = new User();
        user.setDeviceId(UUID.randomUUID());
        user.setNickname("Test");
        return userRepository.save(user);
    }
}