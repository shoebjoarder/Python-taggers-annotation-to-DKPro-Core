# Installation guide

### Install Python 

- Download the executable form from this [link](https://www.python.org/ftp/python/3.7.9/python-3.7.9-amd64.exe).
- Start installer and click on **Add Python 3.7 to PATH**
- Then click on **Customize installation**
- Make sure **pip** is selected
- In the Advanced Options, select **Install for all users**
- In the end, disable path length limit

### Create a virtual environment

- Start Command Prompt as admin
- Type in the following commands to install virtualenv
```
    pip install virtualenv
    pip install virtualenvwrapper-win
```
- Close Command Prompt window
- Start Command Prompt as non-admin
- Type in the following commands to create a new folder and move into this new folder
```
    mkdir DKPFNLP
```
- Copy the **requirements.txt** file inside the **DKPFNLP** folder
- Type in the following commands into the non-admin Command Prompt window to create a new virtual environment, activate it and install the necessacy python packages
```
    virtualenv DKPFNLP
    .\DKPFNLP\Scripts\activate
    pip install -r requirements.txt
```

## Installation Guide for Linux Users

### Install pip

- Open terminal with Ctrl+Alt+t
- Type in the following to install and update pip
```
    $ sudo apt install python-pip
    $ pip install --upgrade pip
```

### Install and activate virtualenv

- Type in the following into the terminal to install virtualenv
```
    $ sudo pip install virtualenv
```
- Type in the following commands to create a new folder and moveinto this new folder
```
    mkdir DKPFNLP
    cd DKPFNLP
```
- Move the requirement.txt file to the DKPFNLP folder (usually /home/username/DKPFNLP) with your file explorer
- Type in the following commands to create a new (Python3) virtual environment, activate it and install the necessary python packages
```
    $ virtualenv -p python3 .
    $ source ./bin/activate
    $ pip install -r requirements.txt
```

## Use Jupyter (Windows and Linux)
- Open a terminal / Command Prompt window
- Activate your DKPFNLP virtual environment

Ubuntu
```
    source home/username/DKPFNLP/bin/activate
```
Windows
```
C:\Users\username\DKPFNLP\Scripts\activate
```
- Type in
```
    jupyter notebook
```