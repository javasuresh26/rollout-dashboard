package com.walmart.gls.rd.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.gls.rd.entity.AppModule;
import com.walmart.gls.rd.repo.AppModuleRepo;
import com.walmart.gls.rd.utils.AuditValueUpdateUtils;

@RestController
@RequestMapping(value = "/appModule")
public class AppModuleController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AppModuleRepo appModuleRepo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<AppModule> getAllAppModule() {
		LOG.info("Getting all");
		return appModuleRepo.findAll();
	}
	
	@RequestMapping(value = "/{artifactId}", method = RequestMethod.GET)
	public AppModule getAppModuleByArtifactId(@PathVariable(name = "artifactId") String artifactId) {
		LOG.info("Getting all by {}", artifactId);
		Optional<AppModule> module = appModuleRepo.findById(artifactId);
		return module.isPresent() ? module.get() : null;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public AppModule addAppModule(@RequestBody AppModule entity) {
		LOG.info("Saving..");
		AuditValueUpdateUtils.updateAuditDateValue(entity);
		return appModuleRepo.save(entity);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public AppModule updateAppModule(@RequestBody AppModule entity) {
		LOG.info("updating..");
		AuditValueUpdateUtils.updateAuditDateValue(entity);
		return appModuleRepo.save(entity);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteAppModule(@RequestBody AppModule entity) {
		LOG.info("deleting..");
		 appModuleRepo.delete(entity);
	}
}
