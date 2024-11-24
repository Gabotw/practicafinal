package org.hign.platform.practicafinal.personnel.interfaces.REST;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetAllExaminersQuery;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetExaminerByIdQuery;
import org.hign.platform.practicafinal.personnel.interfaces.REST.resources.CreateMentalStateExamResource;
import org.hign.platform.practicafinal.personnel.interfaces.REST.resources.MentalStateExamResource;
import org.hign.platform.practicafinal.personnel.interfaces.REST.transform.CreateMentalStateExamCommandFromAssembler;
import org.hign.platform.practicafinal.personnel.interfaces.REST.transform.MentalStateExamResourceFromEntityAssembler;
import org.hign.platform.practicafinal.personnel.domain.services.MentalStateExamCommandService;
import org.hign.platform.practicafinal.personnel.domain.services.MentalStateExamQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/mental-state-exam", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Mental State Exam", description = "Mental State Exam Management Endpoints")
public class MentalStateExamController {
    private final MentalStateExamCommandService mentalStateExamCommandService;
    private final MentalStateExamQueryService mentalStateExamQueryService;

    public MentalStateExamController(MentalStateExamCommandService mentalStateExamCommandService, MentalStateExamQueryService mentalStateExamQueryService) {
        this.mentalStateExamCommandService = mentalStateExamCommandService;
        this.mentalStateExamQueryService = mentalStateExamQueryService;
    }

    @PostMapping
    public ResponseEntity<MentalStateExamResource> createMentalStateExam(@RequestBody CreateMentalStateExamResource createMentalStateExamResource){
        var createMentalStateExamCommand = CreateMentalStateExamCommandFromAssembler.toCommandFromResource(createMentalStateExamResource);
        var mentalStateExamId = mentalStateExamCommandService.handle(createMentalStateExamCommand);
        if(mentalStateExamId == null){
            return ResponseEntity.badRequest().build();
        }
            var getMentalStateExamByIdQuery = new GetExaminerByIdQuery(mentalStateExamId);
        var mentalStateExam = mentalStateExamQueryService.handle(getMentalStateExamByIdQuery);
        if(mentalStateExam.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var mentalStateExamResource = MentalStateExamResourceFromEntityAssembler.toResourceFromEntity(mentalStateExam.get());
        return new ResponseEntity<>(mentalStateExamResource, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<MentalStateExamResource>> getAllMentalStateExams(){
        var getAllMentalStateExamsQuery = new GetAllExaminersQuery();
        var mentalStateExam = mentalStateExamQueryService.handle(getAllMentalStateExamsQuery);
        var mentalStateExamResource = mentalStateExam.stream().map(MentalStateExamResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(mentalStateExamResource);
    }
}
