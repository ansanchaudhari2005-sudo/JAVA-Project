package com.pgs.apiProject.service;

import com.pgs.apiProject.entity.Journal;
import com.pgs.apiProject.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalService {

    private final JournalRepository repository;

    @Autowired
    public JournalService(JournalRepository repository) {
        this.repository = repository;
    }

    public Journal saveEntry(Journal entry) {
        if (entry.getCreatedAt() == null) {
            entry.setCreatedAt(LocalDateTime.now());
        }
        return repository.save(entry);
    }

    public List<Journal> getAllEntries() {
        return repository.findAll();
    }

    public Journal getEntryById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Journal updateEntry(String id, Journal updatedEntry) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTitle(updatedEntry.getTitle());
                    existing.setContent(updatedEntry.getContent());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public boolean deleteEntry(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
