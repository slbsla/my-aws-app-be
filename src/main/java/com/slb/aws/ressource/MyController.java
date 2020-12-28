package com.slb.aws.ressource;


import com.slb.aws.model.FileDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4010")
@Api(value = "Exemple de Services Mockes")
@RequestMapping({"/aws/"})
public class MyController  {

    @ApiOperation(value = "Afficher contenu de dossier")
    @GetMapping(path = {"/display-all/"})
    List<FileDto> displayContent() throws Exception {
        List<FileDto> list = new ArrayList<>();
        list.add(FileDto.builder().fileName("F1")
                .extension("txt")
                .modicationDate(LocalDateTime.now())
                .path("./")
                .size(10)
                .build());
        list.add(FileDto.builder().fileName("F2")
                .extension("csv")
                .modicationDate(LocalDateTime.now())
                .path("./")
                .size(20)
                .build());
        return list ;
    }

    @ApiOperation(value = "Afficher contenu de dossier")
    @GetMapping(path = {"/app-version/"})
    String showVersion() throws Exception {
        return "v-1.0.4" ;
    }
}
