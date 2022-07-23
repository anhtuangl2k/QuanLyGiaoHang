/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.controllers;

import com.tdd.pojos.Auctions;
import com.tdd.pojos.Login;
import com.tdd.pojos.Rate;
import com.tdd.pojos.Shipper;
import com.tdd.service.AuctionsService;
import com.tdd.service.RateService;
import com.tdd.service.ShipperService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiController {
    @Autowired
    private RateService rateService;
    @Autowired
    private AuctionsService auctionsService;
    @Autowired
    private ShipperService shipperService;

    @PostMapping(path = "/api/add-auctions", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Auctions> addAuctions(@RequestBody Map<String, String> params, HttpSession session) {
        Login l = (Login) session.getAttribute("currentUser");
        int id = l.getId();
        
//        List<Shipper> shippers = (List<Shipper>) this.shipperService.getShipperByLoginId(i);
//        Shipper shipper = shippers.get(0);
//        int id = shipper.getId();
        
        if (l != null) {
            try {
                String content = params.get("content");
                long price = Long.parseLong(params.get("price"));
                int orderId = Integer.parseInt(params.get("orderId"));

                Auctions au = this.auctionsService.addAuctions(content, price, orderId, id, l);

                return new ResponseEntity<>(au, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(path = "/api/add-rate", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
     public ResponseEntity<Rate> addRate(@RequestBody Map<String, String> params, HttpSession session){
         Login l = (Login) session.getAttribute("currentUser");
        if (l != null) {
            try {
                String comment = params.get("comment");
                int rating = Integer.parseInt(params.get("rating"));
                int shipperId = Integer.parseInt(params.get("shipperId"));

                Rate rate = this.rateService.addRate(comment, rating, shipperId, l);

                return new ResponseEntity<>(rate, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }
}
