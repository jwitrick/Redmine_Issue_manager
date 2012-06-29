
package redmineissuemanager;

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

import redmineissuemanager.RedmineIssueCreator.*;

public class RedmineIssueManager extends Recorder{

	private final String name;

	@DataBoundConstructor
	public RedmineIssueManager(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

    @Override
    public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener)
        throws InterruptedException, IOException {
        List<String> buildLog = build.getLog(1000);
        listener.getLogger().println("Performing Redmine issue manager...");

        Result pr = build.getResult();
	System.out.println("PRINTING");
	System.out.println(this.name);
	System.out.println(build.getDisplayName());
	System.out.println(build.getId());
	System.out.println(pr);
	System.out.println(buildLog);
	
	System.out.println("CREATING ISSUE");
	ArrayList<String> args = new ArrayList<String>();
	args.add(this.name);
	args.add(build.getDisplayName());
	args.add(build.getId());
	new RedmineIssueCreator(args);	

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
