//package com.example.demo.controller;
//
//import com.example.demo.model.AskRequest;
//import com.example.demo.model.TopicRequest;
//import com.example.demo.model.Response;
//import com.example.demo.service.PineconeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class AskController {
//
//    @Autowired
//    private PineconeService pineconeService;
//
//    @PostMapping("/ask")
//    public ResponseEntity<Response> ask(@RequestBody AskRequest askRequest) {
//        try {
//            String answer = pineconeService.queryPinecone(askRequest.getQuestion());
//            return ResponseEntity.ok(new Response(answer));
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body(new Response("Failed to get a response."));
//        }
//    }
//
//    @PostMapping("/recommend")
//    public ResponseEntity<Response> recommend(@RequestBody TopicRequest topicRequest) {
//        try {
//            String recommendations = pineconeService.getRecommendationsForTopic(topicRequest.getTopic());
//            return ResponseEntity.ok(new Response(recommendations));
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body(new Response("Failed to get recommendations."));
//        }
//    }
//}
