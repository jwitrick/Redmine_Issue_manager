
from optparse import OptionParser, OptionGroup

class ArgumentParser:
    def __init__(self):
        self.parser = OptionParser()
        self.options = OptionGroup(self.parser, "Options")
        self._build_options()

    def _build_options(self):
        self.parser.add_option('-u', '--user', dest='user', action='store', default='admin', help="Redmine user")
        self.parser.add_option('-P', '--password', dest='password', action='store', default='admin', help="Redmine user's password")
        self.parser.add_option('-k', '--api-key', dest='key', action='store', default='api-key', help="Redmine user's api-key")
        self.parser.add_option('-c', '--config-file', dest='config', action='store', help='Has the needed information for successfully running this tool. [default: %default]')
        self.parser.add_option('-v', '--verbose', dest='verbose', action='store_true', help='How much information do you want printed to the console. [default: %default]')
        self.parser.add_option('-l', '--log-file', dest='log-file', action='store', default=None, help='Log file to write data to, Over rides the file specified in the config file [default: %default]')
        self.parser.add_option('', '--log-level', dest='log-level', action='store', default='INFO', help='The level of detail to write to the log. (DEBUG, INFO, WARNING, CRITICAL) [defaul: %default]')

        self.parser.add_option('-p', '--project', dest='project', action='store', help="What redmine project do you want to use?")
        self.parser.add_option('', '--issue-subject', dest='issue-subject', action='store', help="Issue subject")
        self.parser.add_option('', '--issue-desc', dest='issue-desc', action='store', help="Issue description")

    def _parse_args(self):
        try:
            (self.options, args) = self.parser.parse_args()
        except:
            return False
        return True

    def parse_error(self, error_msg):
        return self.parser.error(error_msg)

    def get_option_value(self, value):
        try:
            return getattr(self.options, value)
        except:
            return None

