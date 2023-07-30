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
    public String guardarRespuestas(@RequestParam("q1") String q1,
                                    @RequestParam("q2") String q2,
                                    @RequestParam("q3") String q3,
                                    @RequestParam("q4") String q4,
                                    @RequestParam("q5") String q5,
                                    @RequestParam("q6") String q6

    ) {
        Checklist respuesta1 = new Checklist();
        respuesta1.setPregunta("¿La entidad empleadora cuenta con Reglamento Interno de Higiene y Seguridad (RIHS) y/o Orden Higiene y Seguridad (RIOHS) actualizado, según corresponda?");
        respuesta1.setRespuesta(q1);
        checklistRepo.save(respuesta1);

        Checklist respuesta2 = new Checklist();
        respuesta2.setPregunta("¿La entidad empleadora mantiene los registros actualizados de la recepción o entrega del RIHS o RIOHS a cada trabajador(a)?");
        respuesta2.setRespuesta(q2);
        checklistRepo.save(respuesta2);

        Checklist respuesta3 = new Checklist();
        respuesta3.setPregunta("¿La entidad empleadora cumple con la obligación de informar a sus trabajadores sobre riesgos laborales que entrañan sus labores, las medidas de prevención y los métodos de trabajo correctos, de una manera oportuna y conveniente, manteniendo un registro de dicha actividad?");
        respuesta3.setRespuesta(q3);
        checklistRepo.save(respuesta3);

        Checklist respuesta4 = new Checklist();
        respuesta4.setPregunta("¿En la entidad empleadora se ha constituido y se encuentra en funcionamiento el Comité Paritario de Higiene y Seguridad? (entidad empleadora con más de 25 trabajadores permanentes). Ley N° 16.744 Art. Nº 66; Ley Nº 19.345, Art. Nº 6, D.S. Nº 54.");
        respuesta4.setRespuesta(q4);
        checklistRepo.save(respuesta4);

        Checklist respuesta5 = new Checklist();
        respuesta5.setPregunta("¿El Comité Paritario de Higiene y Seguridad cuenta con un programa de trabajo propio y se reúne como mínimo una vez al mes?");
        respuesta5.setRespuesta(q5);
        checklistRepo.save(respuesta5);

        Checklist respuesta6 = new Checklist();
        respuesta6.setPregunta("¿El Comité Paritario de Higiene y Seguridad realiza investigación de las causas de los accidentes del trabajo y las enfermedades profesionales?");
        respuesta6.setRespuesta(q6);
        checklistRepo.save(respuesta6);



        return "redirect:/inicio";
    }
}
