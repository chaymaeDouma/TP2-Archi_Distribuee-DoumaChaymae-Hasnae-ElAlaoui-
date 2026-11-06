package fr.univ.tp.serviceetudiants.controller;

import fr.univ.tp.serviceetudiants.model.Etudiant;
import fr.univ.tp.serviceetudiants.repository.EtudiantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    private final EtudiantRepository repo;

    public EtudiantController(EtudiantRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Etudiant> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Etudiant get(@PathVariable int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé"));
    }

    @PostMapping
    public Etudiant create(@RequestBody Etudiant e) {
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repo.delete(id);
    }
}