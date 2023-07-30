package com.example.PrevencionRiesgosAppli.controladores;

import com.example.PrevencionRiesgosAppli.modelo.Checklist;
import com.example.PrevencionRiesgosAppli.repositorios.ChecklistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChecklistController {

    @Autowired
    ChecklistRepo checklistRepo;

    @GetMapping("/checklist")
    public String mostrarChecklist(){
        return "checklist";
    }

    @PostMapping("/guardarChecklist")
    public String guardarRespuestas(@RequestParam(value="q1", defaultValue = "NO") String q1,
                                    @RequestParam(value="q2", defaultValue = "NO") String q2,
                                    @RequestParam(value="q3", defaultValue = "NO") String q3,
                                    @RequestParam(value="q4", defaultValue = "NO") String q4,
                                    @RequestParam(value="q5", defaultValue = "NO") String q5,
                                    @RequestParam(value="q6", defaultValue = "NO") String q6

    ) {
        Checklist respuesta1 = new Checklist();
        respuesta1.setPregunta("pregunta 1");
        respuesta1.setRespuesta(q1);
        checklistRepo.save(respuesta1);

        Checklist respuesta2 = new Checklist();
        respuesta2.setPregunta("pregunta 2");
        respuesta2.setRespuesta(q2);
        checklistRepo.save(respuesta2);

        Checklist respuesta3 = new Checklist();
        respuesta3.setPregunta("pregunta 3");
        respuesta3.setRespuesta(q3);
        checklistRepo.save(respuesta3);

        Checklist respuesta4 = new Checklist();
        respuesta4.setPregunta("pregunta 4");
        respuesta4.setRespuesta(q4);
        checklistRepo.save(respuesta4);

        Checklist respuesta5 = new Checklist();
        respuesta5.setPregunta("pregunta 5");
        respuesta5.setRespuesta(q5);
        checklistRepo.save(respuesta5);

        Checklist respuesta6 = new Checklist();
        respuesta6.setPregunta("pregunta 6");
        respuesta6.setRespuesta(q6);
        checklistRepo.save(respuesta6);



        return "redirect:/inicio";
    }
}
