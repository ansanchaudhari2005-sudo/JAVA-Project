package com.pgs.apiProject.controller;

import com.pgs.apiProject.entity.Journal;
import com.pgs.apiProject.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
@CrossOrigin(origins = "*")
public class JournalController {

    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping
    public ResponseEntity<Journal> createEntry(@RequestBody Journal entry) {
        Journal savedEntry = journalService.saveEntry(entry);
        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Journal> getAllEntries() {
        return journalService.getAllEntries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Journal> getEntryById(@PathVariable String id) {
        Journal entry = journalService.getEntryById(id);
        if (entry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Journal> updateEntry(@PathVariable String id, @RequestBody Journal updatedEntry) {
        Journal entry = journalService.updateEntry(id, updatedEntry);
        if (entry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable String id) {
        boolean deleted = journalService.deleteEntry(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

// user request (Url hit) -> controller -> service -> repository