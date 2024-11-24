package org.hign.platform.practicafinal.assessment.interfaces.REST;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetAllExaminersQuery;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetExaminerByIdQuery;
import org.hign.platform.practicafinal.assessment.domain.services.ExaminerCommandService;
import org.hign.platform.practicafinal.assessment.domain.services.ExaminerQueryService;
import org.hign.platform.practicafinal.assessment.interfaces.REST.resources.CreateExaminerResource;
import org.hign.platform.practicafinal.assessment.interfaces.REST.resources.ExaminerResource;
import org.hign.platform.practicafinal.assessment.interfaces.REST.transform.CreateExaminerCommandFromAssembler;
import org.hign.platform.practicafinal.assessment.interfaces.REST.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/examiners", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Examiner", description = "Examiner Management Endpoints")
public class ExaminerController {
    private final ExaminerCommandService examinerCommandService;
    private final ExaminerQueryService examinerQueryService;

    public ExaminerController(ExaminerCommandService examinerCommandService, ExaminerQueryService examinerQueryService) {
        this.examinerCommandService = examinerCommandService;
        this.examinerQueryService = examinerQueryService;
    }

    @PostMapping
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource createExaminerResource){
        var createExaminerCommand = CreateExaminerCommandFromAssembler.toCommandFromResource(createExaminerResource);
        var examinerId = examinerCommandService.handle(createExaminerCommand);
        if(examinerId == null){
            return ResponseEntity.badRequest().build();
        }
        var getExaminerByIdQuery = new GetExaminerByIdQuery(examinerId);
        var examiner = examinerQueryService.handle(getExaminerByIdQuery);
        if(examiner.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var examinerResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(examiner.get());
        return new ResponseEntity<>(examinerResource, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ExaminerResource>> getAllExaminer(){
        var getAllExaminerQuery = new GetAllExaminersQuery();
        var examiner = examinerQueryService.handle(getAllExaminerQuery);
        var examinerResource = examiner.stream().map(ExaminerResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(examinerResource);
    }
}
