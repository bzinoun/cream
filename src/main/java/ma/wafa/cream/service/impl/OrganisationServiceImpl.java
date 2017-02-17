package ma.wafa.cream.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import ma.wafa.cream.domain.Agent;
import ma.wafa.cream.repository.AgentRepository;
import ma.wafa.cream.service.OrganisationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrganisationServiceImpl implements OrganisationService {
    
    private final Logger log = LoggerFactory.getLogger(OrganisationServiceImpl.class);
    
    @Inject
    private AgentRepository agentRepository;

    @Override
    public String getManagerCommercial(String codeAgent) {
        Agent agent = agentRepository.getOne(codeAgent);
        return agent.getManagerCommercialJunior();
    }
    
    @Override
    public List<String> getAgents(String managerCommercial) {
        return agentRepository.findByManagerCommercialJunior(managerCommercial).stream().map(e -> e.getCodeAgent())
                .collect(Collectors.toList());
    }
    
    @Override
    public List<String> getManagers(String codeAgent) {
        Agent agent = agentRepository.getOne(codeAgent);

        List<String> managers = new ArrayList<String>();
        managers.add(agent.getManagerCommercialJunior());
        managers.add(agent.getManagerCommercialSenior());
        // TODO : Completer la liste
 
        return managers;
    }
    
}
