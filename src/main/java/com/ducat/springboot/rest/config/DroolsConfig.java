package com.ducat.springboot.rest.config;

import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {
	@Bean
	public StatelessKieSession getStateLessKieSession(@Autowired KieContainer kieContainer) {
		return kieContainer.newStatelessKieSession();
	}

	@Bean
	KieContainer getKieContainer() {
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource("rules.drl"));
		final KieRepository kieRepository = kieServices.getRepository();
		kieRepository.addKieModule(kieRepository::getDefaultReleaseId);
		KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
		kb.buildAll();
		KieModule kieModule = kb.getKieModule();
		return kieServices.newKieContainer(kieModule.getReleaseId());

	}

	/*
	 * private KieServices kieServices = KieServices.Factory.get();
	 * 
	 * private KieFileSystem getKieFileSystem() throws IOException{ KieFileSystem
	 * kieFileSystem = kieServices.newKieFileSystem();
	 * kieFileSystem.write(ResourceFactory.newClassPathResource("rules.drl"));
	 * return kieFileSystem; }
	 * 
	 * @Bean public KieContainer getKieContainer() throws IOException{
	 * System.out.println("Container created..."); getKieRepository(); KieBuilder kb
	 * = kieServices.newKieBuilder(getKieFileSystem()); kb.buildAll(); KieModule
	 * kieModule = kb.getKieModule(); KieContainer kieContainer =
	 * kieServices.newKieContainer(kieModule.getReleaseId()); return kieContainer; }
	 * 
	 * private void getKieRepository() { final KieRepository kieRepository =
	 * kieServices.getRepository(); kieRepository.addKieModule(new KieModule() {
	 * public ReleaseId getReleaseId() { return kieRepository.getDefaultReleaseId();
	 * } }); }
	 * 
	 * @Bean public KieSession getKieSession() throws IOException{
	 * System.out.println("session created..."); return
	 * getKieContainer().newKieSession(); }
	 */
}