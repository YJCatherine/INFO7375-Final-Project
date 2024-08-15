//package com.example.demo.controller;
//
//import com.example.demo.model.RecommendRequest;
//import com.example.demo.model.Response;
//import com.example.demo.service.RecommendService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class RecommendController {
//
//    @Autowired
//    private RecommendService recommendService;
//
//    @PostMapping("/recommend")
//    public ResponseEntity<Response> recommend(@RequestBody RecommendRequest recommendRequest) {
//        try {
//            String recommendations = recommendService.getRecommendations(recommendRequest.getTopic());
//            return ResponseEntity.ok(new Response(recommendations));
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body(new Response("Failed to get recommendations."));
//        }
//    }
//}
