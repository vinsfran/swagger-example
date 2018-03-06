FROM ubuntu:16.04
LABEL Descripción="Esta es una imagen base con maven y jdk1.8" Autor="Vicente Insfrán" Versión="v1.0.0"

# Update the APT cache
RUN sed -i.bak 's/main$/main universe/' /etc/apt/sources.list
RUN apt-get update
RUN apt-get upgrade -y

# Install and setup project dependencies
RUN apt-get install -y curl wget
RUN apt-get install -y locales
RUN locale-gen es_ES es_ES.UTF-8

#prepare for Java download
RUN apt-get install -y python-software-properties
RUN apt-get install -y software-properties-common

#grab oracle java (auto accept licence)
RUN add-apt-repository -y ppa:webupd8team/java
RUN apt-get update
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java8-installer
#Utilitarios
RUN apt-get update && apt-get install -y maven
RUN apt-get update && apt-get install -y nano
RUN apt-get update && apt-get install -y net-tools
RUN apt-get update && apt-get install -y iputils-ping
RUN apt-get autoremove -y
RUN apt-get autoclean -y
#cp /src/settings.xml /usr/share/maven/conf