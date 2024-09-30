package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Procurement;

import com.pxp.SQLite.demo.service.ProcurementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("procurement")
@RequiredArgsConstructor
public class ProcurementController {

  private final ProcurementService service;


  @GetMapping(path ="/", produces = "application/json")
  public ResponseEntity<ArrayList<Procurement>> getAllProcurements() {
    log.info("Поступил запрос на получение информации обо всех закупках за последние два дня");

    try {
      ArrayList<Procurement> responce = service.getAllProcurements();
      return new ResponseEntity<>(responce, HttpStatus.OK);
//      return ResponseEntity.ok().body(service.getAllProcurements());
    } catch (NoSuchElementException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping(path ="/{id}", produces = "application/json")
  public ResponseEntity<Procurement> getProcurement(@PathVariable int id) {
    log.info("Поступил запрос на получение информации о закупке: procurementId={}"
            , id);

    try {
      return ResponseEntity.ok().body(service.getProcurement(id));
    } catch (NoSuchElementException e) {
      return ResponseEntity.notFound().build();
    }
  }
}
