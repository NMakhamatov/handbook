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

    //good
    @Override
    @PostMapping(value = "/save")
    public ResponseEntity createDepartment(@RequestBody CreateView createView) {
        System.out.println("КОНТРОЛЛЕР: СОЗДАНИЕ НОВОГО ОТДЕЛА");
        departmentService.createDepartment(createView);
        return new ResponseEntity<>(new CustomSuccessResponse(), HttpStatus.OK);
    }

    //works good, but todo:change manager's name viewing
    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomDataOut> searchDepartmentById(@PathVariable  Long id) {
        System.out.println("КОНТРОЛЛЕР: ПОИСК ОТДЕЛА ПО ID");
        DepartmentEntityDto dto = departmentService.searchDepartmentById(id);
        CustomDataOut<DepartmentEntityDto> dataOut = new CustomDataOut<>(dto);
        return new ResponseEntity<CustomDataOut>(dataOut,HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity closeDepartment(@PathVariable Long id) {
       departmentService.closeDepartment(id);
        return new ResponseEntity<>(new CustomSuccessResponse(),HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/{parentId}/subDepartments")
    public ResponseEntity<CustomDataOut> getSubDepartments(@PathVariable Long parentId) {
      List<DepartmentEntityDto> listBranches =  departmentService.searchListBranches(parentId);
      CustomDataOut<List<DepartmentEntityDto>> dataOut = new CustomDataOut<>(listBranches);
        return new ResponseEntity<CustomDataOut>(dataOut,HttpStatus.OK);
 }

    @Override
    @PutMapping(value = "/reassignDepartment")
    public ResponseEntity reassignDepartment(@RequestBody Reassignment reassignment) {
//        System.out.println("КОНТРОЛЛЕР: СМЕНА РОДИТЕЛЬНОСКОГО ОТДЕЛА");
        departmentService.reassignDepartment(reassignment);
        return new ResponseEntity<>(new CustomSuccessResponse(),HttpStatus.OK);
    }
}
