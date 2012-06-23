
import logging
import sys
import redmine
import urllib
import urllib2
from argument_parser import ArgumentParser

class IssueTracker(object):
    def __init__(self, args=None):
        self.arg_parser = ArgumentParser()
        self._parse_args(args)
        self._initiate_redmine_connection()
        self._create_issue()

    def _parse_args(self, args):
        if args is None:
            if not self.arg_parser._parse_args():
                sys.exit(0)

    def _initiate_redmine_connection(self):
        self.my_redmine = redmine.Redmine("http://184.106.117.23:3000", key="gRDPx4GPcTJX1cVCFciJ")

    def _get_issue(self):
        #my_redmine = redmine.Redmine("http://184.106.117.23:3000/", username='admin', password='admin')
        issue = my_redmine.getIssue(1)
        print issue

    def _create_issue(self):
        issue_data = self._build_new_issue()
        project = self.my_redmine.getProject(self.arg_parser.get_option_value('project'))
        #new_issue = self.my_redmine.newIssueFromDict(issue_data)
        #new_issue = self.my_redmine.newIssueFromDict(issue_data)
        #new_issue = project.newIssueFromDict(issue_data)
        new_issue = project.newIssue(issue_data['subject'], issue_data['description'])
        return True

    def _build_new_issue(self):
        issue_data = {}
        #issue_data['subject'] = self.arg_parser.get_option_value('subject')
        #issue_data['description'] = self.arg_parser.get_option_value('description')
        issue_data['subject'] = "testst"#self.arg_parser.get_option_value('subject')
        issue_data['description'] = "afwefwefwe"#self.arg_parser.get_option_value('description')
        issue_data['estimated_hours'] = ""
        issue_data['done_ratio'] = "0"
        issue_data['start_date'] = ""
        return issue_data


if __name__ == "__main__":
    #args = ['-c/tmp/rembackup_funct.ini']
    #app = Rembackup(args)
    app = IssueTracker()
    #app.setup_main_app()
    sys.exit(0)
