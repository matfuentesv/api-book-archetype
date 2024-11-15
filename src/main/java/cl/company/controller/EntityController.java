package cl.company.controller;

import cl.company.exception.ErrorResponse;
import cl.company.model.EntityModel;
import cl.company.service.EntityService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Log
public class EntityController {

    @Autowired
    EntityService entityService;


    @GetMapping(value = "/findAllEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EntityModel>> findAllEntity() {
        log.info("Se solicita la lista de todas las entidades.");
        return ResponseEntity.ok(entityService.findAll());
    }

    @GetMapping("/findEntity/{id}")
    public ResponseEntity<Object> findEntity(@PathVariable Long id) {

        if (StringUtils.containsWhitespace(String.valueOf(id))|| id == null) {
            log.info("El id no se ingreso");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }
        return ResponseEntity.ok(entityService.findEntity(id));
    }

    @PostMapping("/createEntity")
    public ResponseEntity<Object> createEntity(@Valid @RequestBody EntityModel entityModel,
                                             BindingResult bindingResult) throws MethodArgumentNotValidException {

        if (entityModel == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }

        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        return ResponseEntity.ok(entityService.createEntity(entityModel));
    }


    @PutMapping("/updateEntity")
    public ResponseEntity<Object> updateEntity(@Valid @RequestBody EntityModel entityModel,
                                             BindingResult bindingResult) throws MethodArgumentNotValidException {

        if (entityModel == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }

        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        return ResponseEntity.ok(entityService.updateEntity(entityModel));
    }

    @DeleteMapping("/deleteEntity/{id}")
    public ResponseEntity<Object> deleteEntity(@PathVariable Long id) {

        if (StringUtils.containsWhitespace(String.valueOf(id))|| id == null) {
            log.info("El id no se ingreso");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }


        EntityModel entityModel = entityService.findEntity(id);

        if (entityModel != null) {
            entityService.deleteEntity(id);
            return ResponseEntity.ok(new ErrorResponse("Entidad eliminada"));
        } else {
            log.info("Entidad no encontrado con id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Entidad no encontrado"));
        }
    }

}


