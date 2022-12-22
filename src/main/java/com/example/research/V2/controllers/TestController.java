package com.example.research.V2.controllers;

import com.example.research.V2.core.AlgorithmUtils;
import com.example.research.V2.core.context.K;
import com.example.research.V2.core.context.Matrix;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final AlgorithmUtils algorithmUtils;

    @GetMapping("/launch")
    public String test() {
        double [][] healthyValues = {
                {1, 0.4, 0.2, 0},
                {1, 0.4, 0.6, 0},
                {1, 0.8, 0.8, 0},
                {0, 0.8, 0.8, 1},
                {0.2, 0.2, 0.6, 1},
                {1, 0.2, 0, 0.8},
                {1, 0.5, 0.4, 0},
                {0.2, 0.6, 0.2, 1}
        };

//        double [][] unHealthyValues = {
//                {10, 0.2, -4, 0.8},
//                {70, 0.5, -6, 0},
//                {100, 0.6, 2, 1}
//        };
//
//        String result = "";
//
//        K k = new K(
//                Arrays.asList("a", "b", "c"),
//                Arrays.asList("strenght", "agile", "health", "mind"),
//                new Matrix(unHealthyValues));
//
//        result += k.getI().toString();
//        result += "\n";
//        result += k.validate().getI().toString();
//
//        return result;

        K k = new K(
                Arrays.asList("AP", "DN", "IM", "SR", "KB", "ZG", "TZ", "ZP"),
                Arrays.asList("S", "A", "I", "Sp"),
                new Matrix(healthyValues)
        );
        String kString = k.toString();

        String vString = k.validate().toString();

        String cString = algorithmUtils.getConcepts(k).toString();

        return String.format("%S\n%S\n%S", kString, vString, cString);
    }


}


