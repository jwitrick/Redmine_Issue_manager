/**
 * @author jwitrick
 *
 */

package redmineissuemanager;

import java.io.IOException;
import java.net .URISyntaxException;
import java.util.List;
import java.util.ArrayList;

import com.taskadapter.redmineapi.*;
import com.taskadapter.redmineapi.bean.*;

public class RedmineIssueCreator {


	private String r_host = null;
	private String api_key = null;
	private String project_key = null;
	private RedmineManager mgr = null;

	public RedmineIssueCreator(ArrayList<String> args){
		this.r_host = "";
		this.api_key = "";
		this.project_key = args.get(0);

		this.createConnection();
		this.createIssue(args);
	}

	public void createConnection(){
		this.mgr = new RedmineManager(this.r_host, this.api_key);
	}

	public boolean createIssue(ArrayList<String> args){
		try{
			Issue new_issue = new Issue();
			new_issue.setSubject(args.get(1) +"---" +args.get(2));
			Issue new_issue2 = this.mgr.createIssue(this.project_key, new_issue);
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static String redmineHost = null;
	private static String apiAccessKey = null;
	private static String projectKey = null;
	private static Integer queryId = null; // any
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        	RedmineManager mgr = new RedmineManager(redmineHost, apiAccessKey);
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
