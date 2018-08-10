package org.devgroup.handbook.department.controller;


import org.devgroup.handbook.department.model.DepartmentEntity;
import org.devgroup.handbook.department.service.DepartmentEntityService;
import org.devgroup.handbook.department.view.CreateView;
import org.devgroup.handbook.department.view.DepartmentEntityDto;
import org.devgroup.handbook.department.view.Reassignment;



import org.devgroup.handbook.util.CustomDataOut;
import org.devgroup.handbook.util.CustomSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/department/")
public class DepartmentEntityControllerImpl implements DepartmentEntityController {
   private DepartmentEntityService departmentService;

   @Autowired
    public DepartmentEntityControllerImpl(DepartmentEntityService departmentEntityService) {
        this.departmentService = departmentEntityService;
    }

    @Override
    @PostMapping(value = "/save")
    public ResponseEntity createDepartment(@RequestBody CreateView createView) {
        departmentService.createDepartment(createView);
        return new ResponseEntity<>(new CustomSuccessResponse(), HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomDataOut> searchDepartmentById(@PathVariable  Long id) {
        System.out.println("КОНТРОЛЛЕР: ПОИСК ОТДЕЛА ПО ID");
        DepartmentEntity department = departmentService.searchDepartmentById(id);
//        if (department == null) throw new RuntimeException("CONTROLLER: NULL SUKA!!!!!");
        if (department.getParentDepartment() == null) throw new RuntimeException("blablalba");
        DepartmentEntityDto dto = new DepartmentEntityDto(
                department.getName()
                ,department.getHeadEmployee().getName()
                ,department.getParentDepartment().getName()
        );
        CustomDataOut<DepartmentEntityDto> dataOut = new CustomDataOut<>(dto);
        return new ResponseEntity<CustomDataOut>(dataOut,HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity closeDepartment(@PathVariable Long id) {
       departmentService.closeDepartment(id);
        return new ResponseEntity<>(new CustomSuccessResponse(),HttpStatus.OK);
    }

//    @Override
//    @GetMapping(value = "/{parentId}")
//    public ResponseEntity<CustomDataOut> getSubDepartments(@PathVariable Long parentId) {
//      List<DepartmentEntity> listBranches =  departmentService.searchListBranches(parentId);
//      CustomDataOut<List<DepartmentEntity>> dataOut = new CustomDataOut<>(listBranches);
//        return new ResponseEntity<CustomDataOut>(dataOut,HttpStatus.OK);
//    }

    @Override
    @PutMapping(value = "/reassignDepartment")
    public ResponseEntity reassignDepartment(Reassignment reassignment) {
        departmentService.reassignDepartment(reassignment);
        return new ResponseEntity<>(new CustomSuccessResponse(),HttpStatus.OK);
    }
}
