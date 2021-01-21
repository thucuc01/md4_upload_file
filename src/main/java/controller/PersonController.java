package controller;

import model.Person;
import model.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private Environment environment;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("person",new PersonForm());
        return "create";
    }
    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") PersonForm personForm, Model model){
        // Add other information to Entity
        Person person = new Person(personForm.getId(),personForm.getName());
        // Get default path of file
        String fileUpload = environment.getProperty("file_upload");
        // Get file from request
        MultipartFile file = personForm.getImg();
        // Get name of file
        String image = file.getOriginalFilename();
        // Set name of file to Entity
        person.setImg(image);
        try {
            // Add file to Folder
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("person",person);
        return "result";
    }
}