package org.jboss.unimbus.undertow;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ServletContainer;

/**
 * Created by bob on 1/15/18.
 */
@ApplicationScoped
public class DeploymentManagersProducer {

    @Produces
    @ApplicationScoped
    List<DeploymentManager> deploymentManagers() {
        List<DeploymentManager> managers = new ArrayList<>();
        for (DeploymentInfo each : deploymentInfos) {
            System.err.println( "adding ---> " + each.getDeploymentName() );
            managers.add(container.addDeployment(each));
        }
        return managers;
    }

    @Inject
    ServletContainer container;


    @Inject
    UndertowDeploymentInfos deploymentInfos;

}