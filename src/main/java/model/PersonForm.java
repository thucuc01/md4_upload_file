package model;

import org.springframework.web.multipart.MultipartFile;

public class PersonForm {
    private int id;
    private String name;
    private MultipartFile img;

    public PersonForm() {
    }

    public PersonForm(int id, String name, MultipartFile img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}