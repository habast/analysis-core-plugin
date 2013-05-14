package hudson.plugins.analysis.core;

import jenkins.model.Jenkins;

import hudson.model.AbstractBuild;
import hudson.model.Project;

import hudson.tasks.Builder;
import hudson.tasks.Ant;

/**
 * FIXME: Document type IsAntMethod.
 *
 * @author Ulli Hafner
 */
public class IsAntOptional {
    public static boolean isAntBuild(final AbstractBuild<?, ?> build){

        try{
            if (Jenkins.getInstance().getPlugin("ant") != null) {
                if (build.getProject() instanceof Project) {
                    Project<?, ?> project = (Project<?, ?>)build.getProject();
                    for (Builder builder : project.getBuilders()) {
                        if (builder instanceof Ant) {
                            return true;
                        }
                    }
                }
            }
        }
        catch(ClassNotFoundException ex)
        {
            return false;
        }
        return false;
    }
}

