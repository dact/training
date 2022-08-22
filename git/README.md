#osx
ssh-keygen -C "user@domain.com"
ssh-keygen -C "dubanalexis@gmail.com"

#add pub key to user azure
User settings/SSH Public Keys

#create your name and mail
git config --global user.name "Duban Alexis Cano Tabares"
git config --global user.email "dubanalexis@gmail.com"

#start daemon - pass identity - login cloning repos
eval $(ssh-agent -s) ; ssh-add ~/.ssh/id_rsa_company

To have SSH agent to automatically start with Windows, you can run
set-service ssh-agent -StartupType Automatic - on a super-user powershell prompt.

#create your credentials
ssh-add ~/.ssh/id_rsa_company
id_rsa_github

#change repository
git remote set-url origin ###

#performance
git config --global core.preloadindex true
git config --global core.fscache true
git config --global gc.auto 256

git config --global credential.modalprompt false
git config --global credential.helper store

tag
git tag -a v1.4 -m "my version 1.4"