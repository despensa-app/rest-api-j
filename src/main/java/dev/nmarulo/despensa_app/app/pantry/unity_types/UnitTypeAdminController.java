package dev.nmarulo.despensa_app.app.pantry.unity_types;

import dev.nmarulo.despensa_app.app.pantry.unity_types.dtos.UnitTypeAdminReq;
import dev.nmarulo.despensa_app.app.pantry.unity_types.dtos.UnitTypeAdminRes;
import dev.nmarulo.despensa_app.commons.controller.CrudController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/unit-types")
@RequiredArgsConstructor
@Getter
@Tag(name = "Unit Type Admin", description = "Endpoints for managing unit types")
public class UnitTypeAdminController extends CrudController<UnitTypeAdminReq, UnitTypeAdminRes, Long> {
    
    private final UnitTypeAdminService service;
    
}
