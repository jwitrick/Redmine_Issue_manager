
package hudson.plugins.redmineissuemanager;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractProject;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Result;
import hudson.tasks.BatchFile;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.CommandInterpreter;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;

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
        public BuildStepMonitor getRequiredMonitorService() {
                    return BuildStepMonitor.NONE;
                        }
    @Override
    public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener)
        throws InterruptedException, IOException {
        List<String> buildLog = build.getLog(100);
        listener.getLogger().println("Performing Redmine issue manager...");

        Result pr = build.getResult();
        listener.getLogger().println("Finished RUNNING");
        return true;
    }
}
