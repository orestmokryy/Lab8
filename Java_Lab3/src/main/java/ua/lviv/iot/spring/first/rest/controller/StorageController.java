package ua.lviv.iot.spring.first.rest.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.spring.first.rest.model.Thermos;
import ua.lviv.iot.spring.first.rest.service.StorageService;

@RequestMapping("/storages")
@RestController
public class StorageController {
	@Autowired
	private StorageService storageService;
	private Map<Integer, Thermos> storages = new HashMap<>();
	private AtomicInteger idCounter = new AtomicInteger();

	@GetMapping
	public List<Thermos> getThermoses() {
		return new LinkedList<Thermos>(storageService.findAllThermoses());
	}

	@GetMapping(path = "/{id}")
	public Thermos getThermos(final @PathVariable("id") Integer storageId) {
		return storageService.findThermos(storageId);
	}

	@PostMapping
	public Thermos createThermos(final @RequestBody Thermos storage) {
		storage.setId(idCounter.incrementAndGet());
		storageService.createThermos(storage);
		return storage;
	}

	@PutMapping(path = "/{id}")

	public ResponseEntity<Thermos> updateThermos(final @PathVariable("id") Integer storageId, final @RequestBody Thermos thermos) {
		if (storageService.checkIfThermosExists(storageId)) {
			return ResponseEntity.ok(storageService.updateThermos(storageId, thermos));
		}
		return new ResponseEntity<Thermos>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Thermos> deleteThermos(final @PathVariable("id") Integer storageId) {
		HttpStatus status = storages.remove(storageId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return ResponseEntity.status(status).build();
	}

}
