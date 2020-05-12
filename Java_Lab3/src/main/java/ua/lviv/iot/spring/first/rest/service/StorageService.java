package ua.lviv.iot.spring.first.rest.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spring.first.rest.dataaccess.StorageRepository;
import ua.lviv.iot.spring.first.rest.model.Thermos;

@Service
public class StorageService {

	@Autowired
	private StorageRepository storageRepository;

	public Thermos createThermos(Thermos thermos) {
		return storageRepository.save(thermos);
	}

	public void deleteThermos(Integer storageId) {
		storageRepository.deleteById(storageId);
	}

	public boolean checkIfThermosExists(Integer storageId) {
		return storageRepository.existsById(storageId);
	}

	public Thermos findThermos(Integer storageId) {
		return storageRepository.findById(storageId).get();
	}

	public List<Thermos> findAllThermoses() {
		return storageRepository.findAll();
	}

	public Thermos updateThermos(Integer storageId, Thermos thermos) {

		Thermos thermosToUpdate = null;
		Thermos temporaryThermos = storageRepository.findById(storageId).orElse(null);
		if (temporaryThermos != null) {
			thermosToUpdate = new Thermos();
			BeanUtils.copyProperties(temporaryThermos, thermosToUpdate);
			storageRepository.save(thermos);
		}
		return thermosToUpdate;
	}

}
