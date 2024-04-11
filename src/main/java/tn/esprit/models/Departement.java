package tn.esprit.models;

public class Departement {
    private int id, headmaster_id;
    private String name, description;

    public Departement(  int headmaster_id, String name, String description) {

        if (headmaster_id <= 0) {
            throw new IllegalArgumentException("L'identifiant du chef de département doit être un entier positif.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Le nom du département ne peut pas être vide.");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description du département ne peut pas être vide.");
        }
        this.headmaster_id = headmaster_id;
        this.name = name;
        this.description = description;
    }

    public Departement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeadmaster_id() {
        return headmaster_id;
    }

    public void setHeadmaster_id(int headmaster_id) {
        this.headmaster_id = headmaster_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", headmaster_id=" + headmaster_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
