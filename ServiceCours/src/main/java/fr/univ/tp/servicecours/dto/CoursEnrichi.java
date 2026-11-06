package fr.univ.tp.servicecours.dto;

public class CoursEnrichi {
    private Integer id;
    private String titre;
    private Integer etudiantId;
    private String nomEtudiant;

    public CoursEnrichi() {}

    public CoursEnrichi(Integer id, String titre, Integer etudiantId, String nomEtudiant) {
        this.id = id;
        this.titre = titre;
        this.etudiantId = etudiantId;
        this.nomEtudiant = nomEtudiant;
    }

    public Integer getId() { return id; }
    public String getTitre() { return titre; }
    public Integer getEtudiantId() { return etudiantId; }
    public String getNomEtudiant() { return nomEtudiant; }
}