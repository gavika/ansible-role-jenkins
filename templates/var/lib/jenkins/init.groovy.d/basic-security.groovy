#!groovy
import hudson.security.*
import jenkins.model.*

def instance = Jenkins.getInstance()
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
def users = hudsonRealm.getAllUsers()
users_s = users.collect { it.toString() }


def user = hudson.model.User.get('{{ jenkins_admin_username }}');
def password = hudson.security.HudsonPrivateSecurityRealm.Details.fromPlainPassword('{{ jenkins_admin_password }}')
user.addProperty(password)
user.save()
