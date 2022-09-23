package de.kopf3.mshack22backend.api.controller;

import de.kopf3.mshack22backend.wstos.TreeWrapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreeImportController {

    @PostMapping("treeimport")
    public void importGeoJson(@RequestBody TreeWrapper treeWrapper) {
    }
}
