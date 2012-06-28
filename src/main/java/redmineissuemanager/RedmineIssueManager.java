
package redmineissuemanager;
/*
import hudson.Launcher;
import hudson.Extension;
import hudson.util.FormValidation;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.AbstractProject;
import hudson.tasks.Builder;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.QueryParameter;
*/

import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.Util;
import hudson.matrix.MatrixConfiguration;
import hudson.matrix.MatrixProject;
import hudson.model.*;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import hudson.util.FormValidation;
import org.kohsuke.stapler.AncestorInPath;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RedmineIssueManager extends Recorder{

	private final String name;

	@DataBoundConstructor
	public RedmineIssueManager(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
/**
	public String getProject(){
		return project;
	}
*/
    @Override
    public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener)
        throws InterruptedException, IOException {
        List<String> buildLog = build.getLog(100);
        listener.getLogger().println("Performing Redmine issue manager...");

        Result pr = build.getResult();
	System.out.println("PRINTING");
	System.out.println(this.name);
	System.out.println(pr);
        listener.getLogger().println("Finished RUNNING");
        return true;
    }

	@Extension
	public static final class DescriptorImpl extends BuildStepDescriptor<Publisher> {
		public String getDisplayName(){
			return "Create Redmine Issue";
		}	
        	public boolean isApplicable(Class<? extends AbstractProject> aClass) {
	            // Indicates that this builder can be used with all kinds of project types 
        	    return true;
	        }
	}

	public BuildStepMonitor getRequiredMonitorService(){
		return BuildStepMonitor.NONE;
	}
}
