gavika.ansible-role-jenkins
=========

Install and configure Jenkins

Requirements
------------

Any pre-requisites that may not be covered by Ansible itself or the role should be mentioned here. For instance, if the role uses the EC2 module, it may be a good idea to mention in this section that the boto package is required.

Role Variables
--------------

---
jenkins_connection_delay: 5
jenkins_connection_retries: 60
jenkins_home: /var/lib/jenkins
jenkins_hostname: "{{ ansible_host }}"
jenkins_http_port: 8080
jenkins_jar_location: /opt/jenkins-cli.jar
jenkins_url_prefix: ""
jenkins_options: ""
jenkins_java_options: "-Djenkins.install.runSetupWizard=false"

# Plugin list can use the plugin name, or a name/version dict.
jenkins_plugins:
  - blueocean
#  - name: influxdb
#    version: "1.12.1"

jenkins_plugins_state: present
jenkins_plugin_updates_expiration: 86400
jenkins_plugin_timeout: 30
jenkins_plugins_install_dependencies: true
jenkins_updates_url: "https://updates.jenkins.io"

jenkins_admin_username: admin
jenkins_admin_password: password
jenkins_admin_password_file: ""

jenkins_process_user: jenkins
jenkins_process_group: "{{ jenkins_process_user }}"

jenkins_init_changes:
  - option: "JENKINS_OPTS"
    value: "{{ jenkins_options }}"
  - option: "JAVA_OPTS"
    value: "{{ jenkins_java_options }}"
  - option: "JENKINS_HOME"
    value: "{{ jenkins_home }}"
  - option: "JENKINS_PREFIX"
    value: "{{ jenkins_url_prefix }}"
  - option: "JENKINS_PORT"
    value: "{{ jenkins_http_port }}"

# If Jenkins is behind a proxy, configure this.
jenkins_proxy_host: ""
jenkins_proxy_port: ""
jenkins_proxy_noproxy:
  - "127.0.0.1"
  - "localhost"

jenkins_systemd_override_directory: "/etc/systemd/system/jenkins.service.d"
jenkins_systemd_override_file: "{{ jenkins_systemd_override_directory }}/override.conf"

Dependencies
------------

A list of other roles hosted on Galaxy should go here, plus any details in regards to parameters that may need to be set for other roles, or variables that are used from other roles.

Example Playbook
----------------

Including an example of how to use your role (for instance, with variables passed in as parameters) is always nice for users too:

    - hosts: jenkins
      vars:
        jenkins_plugins:
          - blueocean
          - ansible
          - ansicolor
          - workflow-aggregator
          - matrix-auth
          - job-dsl
        jenkins_admin_password: yoursecretpasswordfromvault
      roles:
         - role: gavika.ansible-role-jenkins

License
-------

Apache2

Author Information
------------------
Sudheer Satyanarayana
Gavika Information Technologies Pvt. Ltd.

https://www.gavika.com

https://twitter.com/bngsudheer
https://twitter.com/GavikaIT
https://www.techchorus.net/
