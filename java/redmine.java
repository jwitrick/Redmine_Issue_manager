/**
 * 
 */

/**
 * @author jwitrick
 *
 */

import java.io.IOException;
import java.net .URISyntaxException;
import java.util.List;

import com.taskadapter.redmineapi.*;
import com.taskadapter.redmineapi.bean.*;

public class redmine {

	private static String redmineHost = "http://184.106.117.23:3000";
    private static String apiAccessKey = "ccce0ee6658b09ea4bc7f63704b165e45974e20b";
    private static String projectKey = "cookbooks";
    private static Integer queryId = null; // any
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        RedmineManager mgr = new RedmineManager(redmineHost, "jwitrick2", "oCheek3!");
        //RedmineManager mgr = new RedmineManager(redmineHost, apiAccessKey);
        try {
            //tryGetIssues(mgr);
            createIssue(mgr);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    private static void tryGetIssues(RedmineManager mgr) throws Exception {
        List<Issue> issues = mgr.getIssues(projectKey, queryId);
        for (Issue issue : issues) {
            System.out.println(issue.toString());
        }
    }
    
    private static void createIssue(RedmineManager mgr) throws Exception {
    	Issue new_issue = new Issue();
    	new_issue.setSubject("TEST JAVA SUBJECT");
    	Issue new_issue2 = mgr.createIssue(projectKey, new_issue);
    	System.out.println(new_issue2.toString());
    }
}
