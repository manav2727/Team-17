package com.db.api.controller;

import com.db.api.model.Trade;
import com.db.api.repository.TradeRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/trades")
@CrossOrigin(origins = "http://localhost:8080")
public class TradeController {
	private final TradeRepository tradeRepository;

    public TradeController(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @GetMapping
    public List<Trade> getTrades() {
        return tradeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Trade getTrade(@PathVariable Long id) {
        return tradeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createTrade(@RequestBody Trade trade) throws URISyntaxException {
        Trade savedTrade = tradeRepository.save(trade);
        return ResponseEntity.created(new URI("/tradess/" + savedTrade.getId())).body(savedTrade);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTrade(@PathVariable Long id, @RequestBody Trade trade) {
        Trade currentTrade = tradeRepository.findById(id).orElseThrow(RuntimeException::new);
        currentTrade.setBookid(trade.getBookid());
        currentTrade.setCounterpartyid(trade.getCounterpartyid());
        currentTrade.setSecurityid(trade.getSecurityid());
        currentTrade.setQuantity(trade.getQuantity());
        currentTrade.setStatus(trade.getStatus());
        currentTrade.setPrice(trade.getPrice());
        currentTrade.setBuysell(trade.getBuysell());
        currentTrade.setTradedate(trade.getTradedate());
        currentTrade.setSettlementdate(trade.getSettlementdate());
  
        currentTrade = tradeRepository.save(trade);

        return ResponseEntity.ok(currentTrade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTrade(@PathVariable Long id) {
        tradeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
