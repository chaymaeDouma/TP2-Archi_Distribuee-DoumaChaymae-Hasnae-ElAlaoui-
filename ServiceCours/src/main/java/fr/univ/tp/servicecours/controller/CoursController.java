package fr.univ.tp.servicecours.controller;

import fr.univ.tp.servicecours.dto.CoursEnrichi;
import fr.univ.tp.servicecours.dto.EtudiantDto;
import fr.univ.tp.servicecours.model.Cours;
import fr.univ.tp.servicecours.repository.CoursRepository;
import fr.univ.tp.servicecours.service.EtudiantClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {
    private final CoursRepository repo;
    private final EtudiantClient etudiantClient;

    public CoursController(CoursRepository repo, EtudiantClient etudiantClient) {
        this.repo = repo;
        this.etudiantClient = etudiantClient;
    }

    @GetMapping
    public List<Cours> all() {
        return repo.findAll();
    }

    // ⚠️ khass tkoun 9bel /{id}
    @GetMapping("/enrichis")
    public List<CoursEnrichi> enrichis() {
        return repo.findAll().stream().map(c -> {
            String nom;
            try {
                EtudiantDto e = etudiantClient.getEtudiantById(c.getEtudiantId());
                nom = (e != null) ? e.getNom() : "Inconnu";
            } catch (Exception ex) {
                nom = "Inconnu";   // étudiant ma kaynch wla ServiceEtudiants ta7
            }
            return new CoursEnrichi(c.getId(), c.getTitre(), c.getEtudiantId(), nom);
        }).toList();
    }

    @GetMapping("/{id}")
    public Cours get(@PathVariable int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé"));
    }

    @PostMapping
    public Cours create(@RequestBody Cours c) {
        return repo.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repo.delete(id);
    }
}