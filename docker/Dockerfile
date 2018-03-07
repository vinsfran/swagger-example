FROM devapps.asuncion.gov.py:5000/asu/jdk:1.8.0_161
LABEL Descripción="Esta es una imagen base con Maven" Autor="Vicente Insfrán" Versión="v1.0.0"

# Update the APT cache
RUN sed -i.bak 's/main$/main universe/' /etc/apt/sources.list
RUN apt-get update
RUN apt-get upgrade -y

#Utilitarios
RUN apt-get update && apt-get install -y maven

RUN apt-get autoremove -y
RUN apt-get autoclean -y